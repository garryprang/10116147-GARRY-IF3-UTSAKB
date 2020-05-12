package utsakb.com.garryprang10116147.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utsakb.com.garryprang10116147.R;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContact extends Fragment {

    public FragmentContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return inflater.inflate(R.layout.fragment_contact, container, false);

    }
}
