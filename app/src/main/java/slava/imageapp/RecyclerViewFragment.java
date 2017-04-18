package slava.imageapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import slava.imageapp.common.BaseFragment;

/**
 * Created by Slava on 17.04.2017.
 */

public class RecyclerViewFragment extends BaseFragment {

    @BindView(R.id.myRecyclerView)
    protected RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    ArrayList<String> namesArray;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        namesArray = new ArrayList<>(Arrays.asList(names));
        mLayoutManager = new LinearLayoutManager(getContext());
        rvAdapter = new RecyclerViewAdapter(namesArray);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_recycler_view;
    }

    @Override
    protected void afterCreatedView(View view, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }
}
