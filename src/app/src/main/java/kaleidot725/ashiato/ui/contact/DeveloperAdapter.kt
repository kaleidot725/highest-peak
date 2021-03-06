package kaleidot725.ashiato.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.ashiato.R
import kaleidot725.ashiato.databinding.DeveloperRecyclerItemBinding

class DeveloperAdapter(
    private val owner: LifecycleOwner,
    vms: List<DeveloperViewModel>
) :
    RecyclerView.Adapter<DeveloperViewHolder>() {
    private val vms: MutableList<DeveloperViewModel> = vms.toMutableList()

    fun update(new: List<DeveloperViewModel>) {
        vms.clear()
        vms.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<DeveloperRecyclerItemBinding>(
            inflater,
            R.layout.developer_recycler_item,
            parent,
            false
        )
        return DeveloperViewHolder(owner, binding.root, binding)
    }

    override fun onBindViewHolder(holder: DeveloperViewHolder, position: Int) {
        holder.bind(vms[position])
    }

    override fun getItemCount(): Int = vms.count()
}