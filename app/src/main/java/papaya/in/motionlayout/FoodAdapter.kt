package papaya.`in`.motionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private var foodList: MutableList<FoodModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foodList[position]
        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description
        holder.tvCalories.text = item.calories
        holder.tvRate.text = item.rate
        holder.ivFood.setImageResource(item.imgId)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun addAll(genreList: List<FoodModel>){
        this.foodList.clear()
        this.foodList.addAll(genreList)
        notifyDataSetChanged()
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvCalories: TextView = itemView.findViewById(R.id.tvCalories)
        val tvRate: TextView = itemView.findViewById(R.id.tvRate)
        val ivFood: ImageView = itemView.findViewById(R.id.ivFood)
    }
}