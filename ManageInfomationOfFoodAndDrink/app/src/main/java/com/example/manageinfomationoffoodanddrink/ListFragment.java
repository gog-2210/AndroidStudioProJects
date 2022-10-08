package com.example.manageinfomationoffoodanddrink;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements RecyclerViewInterface{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    private RecyclerView recyclerView;
    private ArrayList<ParentModelClass> parentModelClassArrayList;
    private ArrayList<ChildModelClass> childModelClassArrayList;
    private ArrayList<ChildModelClass> recentlyList;
    private ArrayList<ChildModelClass> favoriteList;
    private ArrayList<ChildModelClass> latestList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.rv_parent);
        parentModelClassArrayList=new ArrayList<>();
        childModelClassArrayList=new ArrayList<>();
        recentlyList=new ArrayList<>();
        favoriteList=new ArrayList<>();
        latestList=new ArrayList<>();
        ParentAdapter parentAdapter;

        latestList.add(new ChildModelClass(R.drawable.img_1,"Lê"));
        latestList.add(new ChildModelClass(R.drawable.img_2,"Sầu riêng"));
        latestList.add(new ChildModelClass(R.drawable.img_3,"Đậu cô ve"));
        latestList.add(new ChildModelClass(R.drawable.img_4,"Vải"));
        latestList.add(new ChildModelClass(R.drawable.img_5,"Nhãn"));
        latestList.add(new ChildModelClass(R.drawable.img_6,"Mít"));
        parentModelClassArrayList.add(new ParentModelClass("Latest List",latestList));

        recentlyList.add(new ChildModelClass(R.drawable.img_3,"Đậu cô ve"));
        recentlyList.add(new ChildModelClass(R.drawable.img_4,"Vải"));
        recentlyList.add(new ChildModelClass(R.drawable.img_6,"Mít"));
        recentlyList.add(new ChildModelClass(R.drawable.img_5,"Nhãn"));
        recentlyList.add(new ChildModelClass(R.drawable.img_7,"Dừa"));
        recentlyList.add(new ChildModelClass(R.drawable.img_6,"Mít"));
        parentModelClassArrayList.add(new ParentModelClass("Recently List",recentlyList));

        favoriteList.add(new ChildModelClass(R.drawable.img_8,"Dâu tây"));
        favoriteList.add(new ChildModelClass(R.drawable.img_5,"Nhãn"));
        favoriteList.add(new ChildModelClass(R.drawable.img_3,"Đậu cô ve"));
        favoriteList.add(new ChildModelClass(R.drawable.img_4,"Vải"));
        favoriteList.add(new ChildModelClass(R.drawable.img_10,"Chanh"));
        favoriteList.add(new ChildModelClass(R.drawable.img_9,"Cam"));
        parentModelClassArrayList.add(new ParentModelClass("Favorite List",favoriteList));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        parentAdapter=new ParentAdapter(parentModelClassArrayList, getContext());
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }
}