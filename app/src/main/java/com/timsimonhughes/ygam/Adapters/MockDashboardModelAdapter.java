package com.timsimonhughes.ygam.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.timsimonhughes.ygam.Model.MockDashboardModel;
import com.timsimonhughes.ygam.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 02/03/17.
 */

public class MockDashboardModelAdapter extends RecyclerView.Adapter<MockDashboardModelAdapter.DessertVh> {


    private List<MockDashboardModel> mMockDashboardModels = new ArrayList<>();

    private Context context;

    public MockDashboardModelAdapter(Context context) {
        this.context = context;

        mMockDashboardModels = MockDashboardModel.prepareDesserts(
                context.getResources().getStringArray(R.array.dessert_names),
                context.getResources().getStringArray(R.array.dessert_descriptions));
    }

    @Override
    public DessertVh onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mock_list_item, parent, false);
        return new MockDashboardModelAdapter.DessertVh(view);
    }

    @Override
    public void onBindViewHolder(DessertVh holder, int position) {
        MockDashboardModel mockDashboardModel = mMockDashboardModels.get(position);

        holder.mName.setText(mockDashboardModel.getName());
        holder.mDescription.setText(mockDashboardModel.getDescription());
        holder.mFirstLetter.setText(String.valueOf(mockDashboardModel.getFirstLetter()));

    }

    @Override
    public int getItemCount() {
        return mMockDashboardModels == null ? 0 : mMockDashboardModels.size();
    }

    public static class DessertVh extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mDescription;
        private TextView mFirstLetter;

        public DessertVh(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.txt_name);
            mDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            mFirstLetter = (TextView) itemView.findViewById(R.id.txt_firstletter);
        }
    }
}
