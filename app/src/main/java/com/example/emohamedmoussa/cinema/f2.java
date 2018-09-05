package com.example.emohamedmoussa.cinema;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class f2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment i
    //nitialization parameters, e.g. ARG_ITEM_NUMBER


    String jsonoffline, url;
    RecyclerView recyclerView;
    Context context;

    public f2() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_f2, container, false);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.context = context;
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.Recmovie);


        jsonoffline = "{\"results\":[{\"vote_count\":0,\"id\":532108,\"video\":false,\"vote_average\":0,\"title\":\"The Suit\",\"popularity\":4.735,\"poster_path\":\"\\/7rwyYJ90ptJsQ3fsUWDC2EfOox3.jpg\",\"original_language\":\"ar\",\"original_title\":\"البدلة\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"The events revolve around Akram (Tamer Hosni), who receives an invitation to attend a masquerade party. He decides to wear police uniforms, which causes him to suffer a crisis as a police officer, while looking for a particular file.\",\"release_date\":\"2018-08-22\"},{\"vote_count\":0,\"id\":542156,\"video\":false,\"vote_average\":0,\"title\":\"Son Of Adam\",\"popularity\":3.463,\"poster_path\":\"\\/bmsInIptVrqLNcuicedQcrEhLEW.jpg\",\"original_language\":\"ar\",\"original_title\":\"بني  آدم\",\"genre_ids\":[18,9648,53],\"backdrop_path\":null,\"adult\":false,\"overview\":\"The story revolves around Adam, a businessman and married, whom everyone around him accuses of being a criminal, gang leader or terrorist, while he says he helps the police arrest them. So, is Adam really innocent or is there a mysterious side unknown to him?\",\"release_date\":\"2018-08-20\"},{\"vote_count\":0,\"id\":544054,\"video\":false,\"vote_average\":0,\"title\":\"El Diesel\",\"popularity\":3.365,\"poster_path\":\"\\/42ViIjIRdeRIweVSOE91TED3j8c.jpg\",\"original_language\":\"en\",\"original_title\":\"El Diesel\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"“El Diesel” is written by Amin Gamal and Mahmoud Hemdan and directed by Karim el-Sobky. It is greatly anticipated by the fans and is expected to be in the lead during Eid El-Adha movie competition.\",\"release_date\":\"2018-08-21\"},{\"vote_count\":0,\"id\":540888,\"video\":false,\"vote_average\":0,\"title\":\"The 'Koways' Family\",\"popularity\":3.273,\"poster_path\":\"\\/xQR1OcQPBk5JroRmElKVIcBG3sZ.jpg\",\"original_language\":\"ar\",\"original_title\":\"الكويسين\",\"genre_ids\":[35],\"backdrop_path\":null,\"adult\":false,\"overview\":\"The 'Koways' Family may seem like a model for the normal family, but it is far from normal, as it unfolds through a series of comedy situations.\",\"release_date\":\"2018-08-20\"},{\"vote_count\":2,\"id\":515224,\"video\":false,\"vote_average\":7.3,\"title\":\"Diamond Dust\",\"popularity\":2.046,\"poster_path\":\"\\/86sJS5Zh3FoPfV2PYbneuPNTR1R.jpg\",\"original_language\":\"ar\",\"original_title\":\"تراب الماس\",\"genre_ids\":[9648,53,18],\"backdrop_path\":\"\\/ct5088QS5KyX92fA7mCorKL5b7y.jpg\",\"adult\":false,\"overview\":\"Taha works as a pharmacist and lives a normal life with his disabled father. When a mysterious murder occurs, Taha's world changes forever. He starts tracking down many secrets that leads him  to unlocks a whole melancholic world of crime!\",\"release_date\":\"2018-08-16\"},{\"vote_count\":0,\"id\":532110,\"video\":false,\"vote_average\":0,\"title\":\"Friday Market\",\"popularity\":0.682,\"poster_path\":\"\\/7mCMQzZ3VotROnHXdrgDNbB7zYB.jpg\",\"original_language\":\"ar\",\"original_title\":\"سوق الجمعة\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"Every week, the poor go to Friday market. The film revolves around the merchants in that market, their personal lives and dealing with customers\",\"release_date\":\"2018-07-25\"},{\"vote_count\":0,\"id\":512959,\"video\":false,\"vote_average\":0,\"title\":\"122\",\"popularity\":0.625,\"poster_path\":\"\\/kiCHmhwhdvlqQKJOngKqJVoVPnf.jpg\",\"original_language\":\"en\",\"original_title\":\"122\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"During a bloody night, a young man and his lover are struggling, not to get to the hospital, but to escape and survive.\",\"release_date\":\"2018-07-24\"},{\"vote_count\":0,\"id\":533163,\"video\":false,\"vote_average\":0,\"title\":\"The Most Dangerous Man\",\"popularity\":0.446,\"poster_path\":\"\\/1qE7iSHxN4oTpkGrOZbRPI03RuI.jpg\",\"original_language\":\"en\",\"original_title\":\"The Most Dangerous Man\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"A comedy that  mocks some of the habits of the Egyptian  society. The film deals with the idea of distortion that has happened to Egypt in recent years, and tries to address the issue and develop the aesthetic image of Egypt.\",\"release_date\":\"2018-07-11\"}],\"page\":1,\"total_results\":8,\"dates\":{\"maximum\":\"2018-08-25\",\"minimum\":\"2018-07-08\"},\"total_pages\":1}";

        url = "https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US";
        new DataShow(jsonoffline, getContext(), recyclerView);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
