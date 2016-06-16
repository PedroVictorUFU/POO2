package com.pedro.aplicacaopoo2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pedro.aplicacaopoo2.R;
import com.pedro.aplicacaopoo2.model.Table;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pedro on 16/06/16.
 */
public class AdapterTables extends RecyclerView.Adapter<AdapterTables.ViewHolderTables> {

    private ArrayList<Table> tables;

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public class ViewHolderTables extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_lugares)
        TextView tvLugares;

        @Bind(R.id.tv_numero)
        TextView tvNumero;
        public ViewHolderTables(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    @Override
    public ViewHolderTables onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_rv_tables, parent, false);
        return new ViewHolderTables(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderTables holder, int position) {
        holder.tvLugares.setText("Número: "+ tables.get(position).getLugares());
        holder.tvNumero.setText("Lugares: "+ tables.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return tables!=null ? tables.size() : 0;
    }
}
