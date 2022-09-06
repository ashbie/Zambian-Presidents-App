package kas.du.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<President> presidentList;
    private Context context;

    public MyAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_president_item, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.tv_presidentName.setText(presidentList.get(position).getName());
        holder.tv_date.setText(String.valueOf(presidentList.get(position).getDate()));
        Glide.with(this.context).load(presidentList.get(position).getImageUrl()).into(holder.iv_president);
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_president;
        TextView tv_presidentName;
        TextView tv_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_president = itemView.findViewById(R.id.iv_president);
            tv_date = itemView.findViewById(R.id.tv_president_year);
            tv_presidentName = itemView.findViewById(R.id.tv_president_name);
        }
    }
}
