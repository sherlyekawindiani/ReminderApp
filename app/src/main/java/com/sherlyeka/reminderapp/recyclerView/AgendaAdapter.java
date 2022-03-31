package com.sherlyeka.reminderapp.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sherlyeka.reminderapp.R;
import java.util.ArrayList;


public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {
    ArrayList<DataAgenda> agendaArrayList;

    public AgendaAdapter(ArrayList<DataAgenda> agendaArrayList) {
        this.agendaArrayList = agendaArrayList;
    }

    @NonNull
    @Override
    public AgendaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_agenda, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaAdapter.ViewHolder holder, int position) {
        holder.judulAgenda.setText(agendaArrayList.get(position).getJudulAgenda());
        holder.hariIni.setText(agendaArrayList.get(position).getHariIni());
        holder.waktuAgenda.setText(agendaArrayList.get(position).getWaktuAgenda());
    }

    @Override
    public int getItemCount() {
        return agendaArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulAgenda, hariIni, waktuAgenda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judulAgenda = itemView.findViewById(R.id.judulAgendaRV);
            hariIni = itemView.findViewById(R.id.textHariIniRV);
            waktuAgenda = itemView.findViewById(R.id.waktuAgendaRV);
        }
    }
}
