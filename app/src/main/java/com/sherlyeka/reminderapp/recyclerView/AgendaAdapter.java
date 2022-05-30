package com.sherlyeka.reminderapp.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sherlyeka.reminderapp.R;
import com.sherlyeka.reminderapp.TodayActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {
    ArrayList<DataAgenda> agendaArrayList;

    public AgendaAdapter(TodayActivity todayActivity, ArrayList<DataAgenda> agendaArrayList) {
        this.agendaArrayList = agendaArrayList;
    }

    @NonNull
    @Override
    public AgendaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_agenda, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.judulAgenda.setText(agendaArrayList.get(position).getJudulAgenda());

        SimpleDateFormat spf = new SimpleDateFormat("dd MMMM yyyy");
        String date = spf.format(agendaArrayList.get(position).getTanggalAgenda());
        holder.tanggalAgenda.setText(date);

        SimpleDateFormat spd = new SimpleDateFormat("h:mm a");
        String time = spd.format(agendaArrayList.get(position).getWaktuAgenda());
        holder.waktuAgenda.setText(time);
    }

    @Override
    public int getItemCount() {
        return agendaArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulAgenda, tanggalAgenda, waktuAgenda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judulAgenda = itemView.findViewById(R.id.judulAgendaRV);
            tanggalAgenda = itemView.findViewById(R.id.tanggalAgendaRV);
            waktuAgenda = itemView.findViewById(R.id.waktuAgendaRV);
        }
    }
}
