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

    private String[] localDataSet;
    private ArrayList<DataAgenda> listAgenda;

    public AgendaAdapter(ArrayList<DataAgenda> listAgenda) {
        this.listAgenda = listAgenda;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
        View view = layoutInflater.inflate(R.layout.card_view_agenda, parent, false) ;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AgendaAdapter.ViewHolder holder, int position) {
        holder.tvjudulAgenda.setText(listAgenda.get(position).getJudulAgenda());
        holder.tvTextHari.setText(listAgenda.get(position).getTexthariIni());
        holder.tvWaktuAgenda.setText(listAgenda.get(position).getWaktuAgenda());

    }

    @Override
    public int getItemCount() {

        return listAgenda.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvjudulAgenda;
        private final TextView tvTextHari;
        private final TextView tvWaktuAgenda;


        public ViewHolder(View view) {
            super(view);

            tvjudulAgenda = (TextView) view.findViewById(R.id.judulAgendaRV);
            tvTextHari = (TextView) view.findViewById(R.id.textHariIniRV);
            tvWaktuAgenda = (TextView) view.findViewById(R.id.waktuAgendaRV);

        }
    }

    public AgendaAdapter(String[] dataSet) {

        localDataSet = dataSet;
    }








}
