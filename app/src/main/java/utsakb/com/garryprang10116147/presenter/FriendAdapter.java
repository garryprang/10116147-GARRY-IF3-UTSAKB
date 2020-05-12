package utsakb.com.garryprang10116147.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import utsakb.com.garryprang10116147.R;
import utsakb.com.garryprang10116147.model.buddyme;
import utsakb.com.garryprang10116147.view.FriendAddUpdateActivity;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {
    private ArrayList<buddyme> listBuddyme = new ArrayList<>();
    private Activity activity;

    public FriendAdapter(Activity activity){
        this.activity = activity;
    }

    public ArrayList<buddyme> getListNotes(){
        return listBuddyme;
    }

    public void setListNotes(ArrayList<buddyme> listNotes){
        if (listNotes.size() > 0 ){
            this.listBuddyme.clear();
        }
        this.listBuddyme.addAll(listNotes);

        notifyDataSetChanged();
    }

    public void addItem(buddyme note){
        this.listBuddyme.add(note);
        notifyItemInserted(listBuddyme.size() -1);
    }

    public void updateItem(int position, buddyme note){
        this.listBuddyme.set(position, note);
        notifyItemChanged(position, note);
    }

    public void removeItem(int position){
        this.listBuddyme.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listBuddyme.size());
    }

    @NonNull
    @Override
    public FriendAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.FriendViewHolder holder, int position) {
        holder.tvNim.setText(listBuddyme.get(position).getNim());
        holder.tvNama.setText(listBuddyme.get(position).getNama());
        holder.tvKelas.setText(listBuddyme.get(position).getKelas());
        holder.tvTelp.setText(listBuddyme.get(position).getTelpon());
        holder.tvEmail.setText(listBuddyme.get(position).getEmail());
        holder.tvIg.setText(listBuddyme.get(position).getIg());
        holder.tvDate.setText(listBuddyme.get(position).getDate());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, FriendAddUpdateActivity.class);
                intent.putExtra(FriendAddUpdateActivity.EXTRA_POSITION, position);
                intent.putExtra(FriendAddUpdateActivity.EXTRA_NOTE, listBuddyme.get(position));
                activity.startActivityForResult(intent, FriendAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return listBuddyme.size();
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder{
        final TextView tvNim, tvNama, tvKelas, tvTelp, tvEmail, tvIg, tvDate;
        final CardView cvNote;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tv_item_nim);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvKelas = itemView.findViewById(R.id.tv_item_kelas);
            tvTelp = itemView.findViewById(R.id.tv_item_telpon);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
            tvIg = itemView.findViewById(R.id.tv_item_ig);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            cvNote = itemView.findViewById(R.id.cv_item_note);
        }
    }
}
