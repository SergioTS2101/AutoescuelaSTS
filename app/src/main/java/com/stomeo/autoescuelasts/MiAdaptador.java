package com.stomeo.autoescuelasts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    private List<ArrayListElementos> mData;
    private LayoutInflater mInflater;
    private Context context;
    final MiAdaptador.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(ArrayListElementos item);
    }

    public MiAdaptador(Context context, List<ArrayListElementos> itemList, MiAdaptador.OnItemClickListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.lista_activity, parent, false);
        return new MiAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MiAdaptador.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    public void setItems(List<ArrayListElementos> items) { mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView opción;

        ViewHolder(View itemView){
            super(itemView);
            logo = itemView.findViewById(R.id.IconoImagen);
            opción = itemView.findViewById(R.id.nameTextView);
        }

        void bindData(final ArrayListElementos item){
            opción.setText(item.getOpcion());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
