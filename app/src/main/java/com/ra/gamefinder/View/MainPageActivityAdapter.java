package com.ra.gamefinder.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ra.gamefinder.R;
import com.ra.gamefinder.WebService.GameFromWeb;

import java.util.ArrayList;
import java.util.List;

    public class MainPageActivityAdapter extends RecyclerView.Adapter<MainPageActivityAdapter.BPHolder> {
        List<GameFromWeb> myGamesList = new ArrayList<>();
        private onItemClickListener listener;

        @NonNull
        @Override
        public BPHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.game_item, parent, false);

            return new BPHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull BPHolder holder, int position) {
            GameFromWeb currentGame = myGamesList.get(position);
            Log.i("==ttt", "onBindViewHolder: "+currentGame);
            holder.textViewGameTitle.setText(currentGame.getTitle());
        }

        @Override
        public int getItemCount() {

            return myGamesList.size();
        }
        public void setBPs(List<GameFromWeb> BPTables){
            myGamesList = BPTables;
            notifyDataSetChanged();

        }

        class  BPHolder extends RecyclerView.ViewHolder{
            private TextView textViewGameTitle;
            private ImageView imageViewGame;
            public BPHolder(@NonNull View itemView) {
                super(itemView);
                textViewGameTitle = itemView.findViewById(R.id.textViewTitle);
                imageViewGame = itemView.findViewById(R.id.imageViewGameItem);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        if (listener!= null && position!= RecyclerView.NO_POSITION) {
                            listener.onItemClick(myGamesList.get(position));
                        }
                    }
                });
            }

        }

        public GameFromWeb getBPAt(int position){

            return myGamesList.get(position);
        }


        public interface onItemClickListener{
            void onItemClick(GameFromWeb gameFromWeb);
        }
        public void setOnItemClickListener(onItemClickListener listener){

            this.listener = listener;
        }

        public MainPageActivityAdapter(List<GameFromWeb> myGamesList1, Context context) {
            myGamesList = myGamesList1;
            Log.i("==ttt", "myGamesList: "+ myGamesList1);
        }



    }





