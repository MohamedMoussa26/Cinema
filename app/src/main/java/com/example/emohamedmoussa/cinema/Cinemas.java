package com.example.emohamedmoussa.cinema;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cinemas extends AppCompatActivity implements View.OnClickListener {

    ArrayList<cinPlace> cinPlaces;
    TextView textView;
    ImageView location, home, locs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas);


        location = (ImageView) findViewById(R.id.loc);
        location.setOnClickListener(this);


        home = (ImageView) findViewById(R.id.home2);
        home.setOnClickListener(this);


        locs = (ImageView) findViewById(R.id.locs);
        locs.setOnClickListener(this);

        String json = "{\n" +
                "   \"html_attributions\" : [],\n" +
                "   \"next_page_token\" : \"CrQCJwEAAIEI_Oa7cbT5wAzKhWBW2vsVfs59u0q2WbGuwUNsHVFpeHeSzvOsCWRFgDJLRomoYRYQ0zkmd35cclAbOcPwlnNpTKPpHceFsmKrgkEieysw-stj3dTX5xLUkeu9W4Hha1NvcAX_z7f2ACJIY1q6Eo5JugWU-vXuaoRLih5cW-6HuK5BQAyBczB5xcqFo6qM4WMOj11WBHqMoia7b1jAPnkYiE1C4P-GCxUV3xfSXyoOfzJUnQzOkDqE3X7sA2AzTWRT7vvdBnDz7RW_ihb403CzxXkhXo7asfUyvY-oLM5YY_rxiw8I5njELTz_T5OVtwL--MmDxfa81Wv3JVV5GtQoCf4wFHqgcH7bnALvH5isaSJ29FAUQperF44SmU-0OjcuirZ2rS9fp8zCwnWgy7MSEIUP642ctgPsOlhHzQQ8u2AaFJRCGY5lXmUOBPDcnPcYe-vR-yHi\",\n" +
                "   \"results\" : [\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 29.9704507,\n" +
                "               \"lng\" : 31.0186881\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 29.97180052989272,\n" +
                "                  \"lng\" : 31.02003792989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 29.96910087010727,\n" +
                "                  \"lng\" : 31.01733827010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"042e8b8912172127fd544a769c1de9293c4f6d8b\",\n" +
                "         \"name\" : \"Vox Cinema\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : false\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3120,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106895411424502398651/photos\\\"\\u003eAtef Al Ekhnawi\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAyQ90Bgr6YUgO1S5VfoTzhQbblCHtwHWexL8j8Gyd5jxO1ysXVX0sRNGFm7dlUJN3LYpbudEerqzjZjzclO8F6wgbNtTWZ3Du1fsE-WBmC1nu05l-31x-61HxkJ6H4walEhBZcKFnZC-BaQc7fEMCVN8LGhRBp4hUFU6SDC9WNKK9Lmr3o9cI6w\",\n" +
                "               \"width\" : 4160\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJQ8eSeORQWBQRvRZt2jLGHqY\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"X2C9+5F 6th of October City, Egypt\",\n" +
                "            \"global_code\" : \"7GXHX2C9+5F\"\n" +
                "         },\n" +
                "         \"rating\" : 4.7,\n" +
                "         \"reference\" : \"CmRbAAAAWRVCt0wgbZQZVCX6MJl5J5dRrQPEFUya_Z1zaFASN-odVEiUfL6oKiUAQ_X7_LOrmSvsDCxu-iC3ceUWNF0rTdoqVpUsZdRvtH27S__fxc_DwGOE-Tg9dmy_9AZjJLG9EhDy_C2du31we1f7t-HFmxbfGhSSleXtFngdjQ-Y07GezjH-nyWLMQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Giza Governorate, Egypt\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0617217,\n" +
                "               \"lng\" : 31.2190347\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.06309427989272,\n" +
                "                  \"lng\" : 31.22033887989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.06039462010727,\n" +
                "                  \"lng\" : 31.21763922010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"f50f6c6c32846701f98be469e5f25afabba9ec8e\",\n" +
                "         \"name\" : \"سينما الزمالك Zamalek Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 4000,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/100675758852171097885/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAA31MgHBZJn3VtDm4r2Sy_tN34GuNfdqrWCpo6rBSLgdUa5QIHxb12srz_PYXK6nB9Cp18Jat61ZKpS3ZxzpO4Oos4qYlBGPUf9YGZX0i3Uw3nxEgQ1JoAKvxtgGi-TyveEhBiaXYoqLN1x-VFNzJQS8yYGhTXDkJejNf5JZtzZIUL-a3PenkcFQ\",\n" +
                "               \"width\" : 6000\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJq2_lr-FAWBQR7PTQQxeXM-E\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"3669+MJ Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H3669+MJ\"\n" +
                "         },\n" +
                "         \"rating\" : 4.5,\n" +
                "         \"reference\" : \"CmRbAAAArnEYUIauc8Zutsg015Tlow0c5RbmzD_5-9KoEsVR7H1RWOPjCLjto7Ku38gUZM4Ng_tmf58VWzmlojm-ZGyEL-YayxFfPY2AEsFv2cVK8hI7Rea0o5LahqBsxdgcSXbpEhBElaRPps1xwD8zBzn0th7sGhSBNLJ4cBN-vvhiI4ynaHHNS9pZww\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Shagaret Al Dor, Mohammed Mazhar, Zamalek\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0203208,\n" +
                "               \"lng\" : 31.4950277\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.02167062989272,\n" +
                "                  \"lng\" : 31.49637752989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.01897097010728,\n" +
                "                  \"lng\" : 31.49367787010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"7dc28e6a9a42f453c9f53e1284f14ceba1478a7f\",\n" +
                "         \"name\" : \"Point 90 Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3000,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/111400387456825077130/photos\\\"\\u003eHaytham Saad eldin\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAA3Um0FFzOytvxy5LRGDoaJyKxUJ6i2_ZOfNcvJ1tcY0IwZMdV_XsjRHotfGnoudxFBHhADBx87nzy5YvSGr9E6I4kZDU2b3Y7_AvTP3dCUsIJIF6GtW-gM-h5yFvblbsVEhCAgWPgT3NgqaiIXYgR9L4-GhTjRUE0hmY5MLYkodd5KYJFFs_WPg\",\n" +
                "               \"width\" : 4000\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJa3AXGlkiWBQRQbn7z62G-Mk\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"2FCW+42 New Cairo City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H2FCW+42\"\n" +
                "         },\n" +
                "         \"rating\" : 4.5,\n" +
                "         \"reference\" : \"CmRbAAAA6ttPNDUhYZqf_9L7FstKSeOvD69Wg4m3jujns4dvtnQdEClrgQyHOSrsxFYYPaIrdbUFRXhqtiMX9ua6A6Qx83b-OOU6qwSycPQhStRRHXI3SJTa3F6Jh1oEqTYZH2qzEhDB4if-2P0Hlg-Ka9eSenvtGhSAMTytuEP-KiaQ4XVvQjzUIvAyvw\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Cairo Governorate, Egypt\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0591967,\n" +
                "               \"lng\" : 31.495984\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.06043657989272,\n" +
                "                  \"lng\" : 31.49750642989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.05773692010727,\n" +
                "                  \"lng\" : 31.49480677010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"11ea8a0394a7610fe4c9dadfa23df4a0196435ca\",\n" +
                "         \"name\" : \"Al Rehab Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 325,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/107859071162775864706/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAA4XrCDwmnQ_ykwgKZysQ24K7p2vA91SJzKhJYA1L3KmE1e6Lg3bQrzTmKMd1FqmQTuBpuMlzImWfAC5k33dZTs-tyUXh3jb7IffHJa5x-WBAjC-fa-XE-CJzeOBrlCtsMEhD2bGyqSUa8Ed1oVAADllWEGhRDyk3FUPoOs6Tn0axx5AR5j5LAqw\",\n" +
                "               \"width\" : 586\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJu7GsvIgYWBQRmOrqmuZAdkE\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"3F5W+M9 New Cairo City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H3F5W+M9\"\n" +
                "         },\n" +
                "         \"rating\" : 3.7,\n" +
                "         \"reference\" : \"CmRbAAAA5De9ZwdFLOyCoUpIagGGnhClIR4lOCOe9CsI-9VrLf0mzRMIV4NuicyI94VA2EUmKgegz6DcnY7ly-Sffg7FxjQNX0t9D1EgqTUU8l5H8TsbeejhsSVDe5n2q_CQfa0DEhAj9UvqO32ihrpkhD5BifHQGhQnrtzs5gb4VdZ6Xe1GF0VnuNWYPQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Phase 1\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.017926,\n" +
                "               \"lng\" : 31.222839\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.01927582989272,\n" +
                "                  \"lng\" : 31.22418882989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.01657617010728,\n" +
                "                  \"lng\" : 31.22148917010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"aa2f4425cf742dffe6e3d531631c8b40dec9f72c\",\n" +
                "         \"name\" : \"Galaxy Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 1013,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106882198093143534083/photos\\\"\\u003eAbdullah Hussein\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAApzzdsQd3jSLGgYkqdnwwV-qMUK7RJHylryqnVhDpHI10TkyqLVhuVLgxy0MZvtDS9KMkcmw0fTQen_gPf09MgC2mqBxvNEwQ_adlHsk3Vl-zeOdrSnqWPoc94FkFv1bjEhAp5Hu8lRu3w37g7F0khxdjGhT3gU6b5H7MzWJsmKO2UdR2d5kZOQ\",\n" +
                "               \"width\" : 1321\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ4QKWKCJHWBQRoCoOMApxXOk\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"269F+54 Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H269F+54\"\n" +
                "         },\n" +
                "         \"rating\" : 4.1,\n" +
                "         \"reference\" : \"CmRbAAAAGGAsyMdDD3uOF6oJAMMp9JfawCwRz3hFD9YwjpFSCSTf3qm7z1Devnev0TXw7VmGIUg0HjEfNMuTzJBqFJkDROVw9LDA56cj4stzhRvsMoJ556gfRHMj7pEgRIVTepvJEhC7ha-YTBP0b22kRnfMXFwCGhTh9XeHSPb1IA7AbBnnpnnoMN3vWg\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"67 ش عبد العزيز ال سعود، المنيل، Al Manial\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0338907,\n" +
                "               \"lng\" : 31.226905\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.03524052989273,\n" +
                "                  \"lng\" : 31.22825482989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.03254087010728,\n" +
                "                  \"lng\" : 31.22555517010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"6cafa5fa5ce46cf7c663846d4fbe2e2681a6b0d2\",\n" +
                "         \"name\" : \"Good News Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3120,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103782127990189734525/photos\\\"\\u003eOmar Alaa\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAASvVkssumCFAnJrfbcAlJjDHh3h3z9R9-mEtzxGbPC5-rKgRh1kaTLfkWXWV_4Ot0scuwAd4jNotS0ybyJg0FzsnVOwhJTLrh3XYeA6cIE6mgwB99GAIFEbVbXSSb5v_JEhDx4szLtlGOEQzO6h4mPGvQGhQhrpQs3fGtG4vtTZ1BNgo4fMeREQ\",\n" +
                "               \"width\" : 4160\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJIWRdaZBAWBQR1H2ETyprp_o\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"26MG+HQ Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H26MG+HQ\"\n" +
                "         },\n" +
                "         \"rating\" : 4,\n" +
                "         \"reference\" : \"CmRbAAAAKOgbIx0TtcZN51jUn_yTSZMKia_Z2RvNHKqk7rMUTec2SxCvlLmgh64wILUXsGUIoF1WqvA6Pq1SXAlJAr0mhd5rrd74_TENm4AX5i8xaQuNUztLsStqJrKm3DcxgnivEhCE3SyUqnW6PqDKO0TRJ7CyGhQAAD91kbFUXnH-zG8T3E0ztRO2ZQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Galleria Mall at Grand Nile Tower, Corniche El Nil, Garden City, Cairo\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0268468,\n" +
                "               \"lng\" : 31.01378769999999\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.02819662989272,\n" +
                "                  \"lng\" : 31.01513752989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.02549697010728,\n" +
                "                  \"lng\" : 31.01243787010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"72d92bc37661b456f1a1c8d14b67c13663209749\",\n" +
                "         \"name\" : \"Americana Plaza Cinema\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : true\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3120,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/111380432221604900475/photos\\\"\\u003eahmed alarf\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAA4MwlZpgMhSo5erRiA6G6N0d4nuXQqJzulqGdj14Olv9jRzkH_KxT-tPxq8dXX_jzSCI75wHj1b3Bh-ERUpcfeDsUkwJz9Z0TKuOm7aXvGAHcsm3UOKvEP80dlChuGYRgEhBEPismEkS1mzBwkYnO-fx2GhQnVyXPDjVWdZj-qMT2peOGHFj_MA\",\n" +
                "               \"width\" : 4160\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ_6crV2paWBQRiTfRItyLRVQ\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"22G7+PG Sheikh Zayed City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H22G7+PG\"\n" +
                "         },\n" +
                "         \"rating\" : 4.5,\n" +
                "         \"reference\" : \"CmRbAAAATuQ755ziJgi2yidHxcDdgQ6755UJ1TmxH5KSyEnBU9YLbjbsEWPHR5jA4Z7hF7t6vcyfsCWflxkBdKH2sPpDN0xg1_juk8YRhaVetAROe2ei0H-Sa_jS1QNt0b4AS8G_EhD5hj7ZXQjlrSA517wfNKAfGhQqx7ocBN9-lWmttA5jQf_R_iXqpg\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Giza Governorate, Egypt\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0260826,\n" +
                "               \"lng\" : 31.4069507\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.02743242989272,\n" +
                "                  \"lng\" : 31.40830052989271\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.02473277010728,\n" +
                "                  \"lng\" : 31.40560087010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"635b265f787debd0b0a4ae348e42bf1a762ac95c\",\n" +
                "         \"name\" : \"Galaxy Cairo Festival City Cinema\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : true\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 2988,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103040698306051203051/photos\\\"\\u003eMichel Hanna\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAXsf-8mRfO6BZnr9KOvZb2Mh2AroiQwfc4uVJiAF-umAoNCdxxRcxWmWmhZc6d4XY_EW6NzZVVFFozkKNd6WyQm6pgv4Y9D48YIEGqMySIcX3G1BaW--yQbx0cUuuHLIFEhAyrIiCSWApT_J34OyP5_J0GhQdQgn0ktyPEckHbw_WDnNp6OO-IQ\",\n" +
                "               \"width\" : 5312\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ_yMTP_w8WBQRliyYbB7YgW8\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"2CG4+CQ New Cairo City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H2CG4+CQ\"\n" +
                "         },\n" +
                "         \"rating\" : 4.5,\n" +
                "         \"reference\" : \"CmRbAAAAqdklxh6UefFLeInlcPR6odG0an9qKJV-CzX9GL5Gcmu9UXLioeKom9z-BPHOFmsmJIw6201z6oztkIDuifJgPVjlaRV_eiSz4-viNQOODioSDHTryRScmwrbLj8-P3zfEhCiDrnuxKe6--P0ElwSsAQUGhQpLPHXc8sT5JIeWZ-tYCbjHxbY1w\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Nasr City\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0391771,\n" +
                "               \"lng\" : 31.2145656\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.04052692989272,\n" +
                "                  \"lng\" : 31.21591542989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.03782727010728,\n" +
                "                  \"lng\" : 31.21321577010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"b89ab6e8dfafd5b91830a59accf493b31bc8b00c\",\n" +
                "         \"name\" : \"El Tahrir Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3120,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/112138505254261526033/photos\\\"\\u003eAbass AbuSrea\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAxkNmbOrnXxrZqnaLCd1qs6eSBKuqmWhIZIydJab-3S2sxBg8Eisb0JmLUGj-fvDXi-9HPf4fiFJxNUmlMEFJw6oCKXLvLh2vAd9QLp6X_A1V4WScn0yOkrCnHyz8VJkeEhAzSZKhVGwulSExN1b6lh-dGhQPzbm30T9vsnCcuq9Rwz2W7WmZow\",\n" +
                "               \"width\" : 4160\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJQQ_WPMZAWBQR35zYk2CsmKk\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"26Q7+MR Giza, Al Omraneyah, Egypt\",\n" +
                "            \"global_code\" : \"8G2H26Q7+MR\"\n" +
                "         },\n" +
                "         \"rating\" : 3.5,\n" +
                "         \"reference\" : \"CmRbAAAAOlDWR3bzbtqLZ2D5sB76nknEc93wrCimByMYKyvEoG6O5e90IiiARRnfpXUl30747B46APayhp4Qg9iKpxPRoIlkeWTnvY6xgEjV6gJZb1QDAiiCJyYqodFBatkexHxMEhA18h3pf69gR1S4OyvPmVBnGhRxLU6Zs5puu1QUIPBAtNNZgZpmTA\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"122 El Tahrir Street, Dokki, Cairo\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0516259,\n" +
                "               \"lng\" : 31.2412573\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.05297572989272,\n" +
                "                  \"lng\" : 31.24260712989273\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.05027607010728,\n" +
                "                  \"lng\" : 31.23990747010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"371f4817af323ed2b84980c94777cb3d8218c086\",\n" +
                "         \"name\" : \"Metro Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 2368,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/102885929987528681372/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAXO6HK5qg04LBqZMgF7eJXd2l8XOVHUKz8nW64kwoOzjC352yZNjQ_JN1Sue4ALx8wERAFK3NBXyywxi_9vT4p_iK58zSSZvQyfeQVZJ4kCHM0Cj-m946SnCG8inoxPgXEhA7Pl-Ifuxi2IkbHHngmIgyGhQVoyW64ZML6DNYkJhhaXjfIBjL6g\",\n" +
                "               \"width\" : 4160\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJhX3Mw79AWBQRFDXh9j8OEyk\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"362R+MG Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H362R+MG\"\n" +
                "         },\n" +
                "         \"rating\" : 3.7,\n" +
                "         \"reference\" : \"CmRbAAAAc9eqPwnTL4nwVbj1QLRsfMFQWmfGBAk7xU_63uDOglsK--dyhO1era_maDKlgiBx5e-3IyFOrIVvVyR7BHFqD1SoRiEgS8r8zret7gw-rngQh1Fu0I90ID19cnKHPUMdEhCBxpMYp3Qts86jpSnGHfYIGhQsa1DcjWPLKKTIxtdruUGaJxfPqQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"26 يوليو، Bab Al Louq, Abdin\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.07395679999999,\n" +
                "               \"lng\" : 31.3444045\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.07530662989272,\n" +
                "                  \"lng\" : 31.34575432989273\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.07260697010727,\n" +
                "                  \"lng\" : 31.34305467010729\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"819e5463b270984dbd4607c91d3332924ecaf37b\",\n" +
                "         \"name\" : \"Golden Stars Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 5312,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115220772204584560739/photos\\\"\\u003eHazem Shafik\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAA1iw0V1aEmSrDVE4HEwXZ9MtRJibhYgzmO4YsmGrJ3b5pVgoz3YCwsAdCnH9b6T6rWqo_xWErQpvRUYOX8-YaFDNPh1Z4NRECsKfikqcYSe1QmHc4bNPwiWgqhifE9INzEhD5cEGtBeauBP82TM6GbozlGhQlRsmxy7XPfohTIGpqX79P050FyA\",\n" +
                "               \"width\" : 2988\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ4WpF_qgVWBQRFt8g-kmsEwQ\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"38FV+HQ Rabaa Buildings, Al Golf, Nasr City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H38FV+HQ\"\n" +
                "         },\n" +
                "         \"rating\" : 4.3,\n" +
                "         \"reference\" : \"CmRbAAAAf3dLH8qaibJFLZZjeaj09yj4Xiqgre4_FHE4FJTBL6Psm8fNighZ2bn6ZOjowZ1jHufqYcedE8sJ-3KTzu-Pn-1EvX-MQ33h0r_U2Afx19F9S4XLRsdLuE8yUpEI0dszEhDBJaksJdLWALOE0sdos0EhGhShrzUONAALbwFif3pA_bCeY14zCw\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"ش عمر بن الخطاب، مصر الجديدة، القاهرة\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.064576,\n" +
                "               \"lng\" : 31.42467599999999\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.06592582989272,\n" +
                "                  \"lng\" : 31.42602582989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.06322617010728,\n" +
                "                  \"lng\" : 31.42332617010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/shopping-71.png\",\n" +
                "         \"id\" : \"b238e20c9af5f92d311046a3e154ccabafd41514\",\n" +
                "         \"name\" : \"Porto Cairo Mall\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : true\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3480,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114537072481291262999/photos\\\"\\u003eM. Sierafi\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAsiPL8yYjdrcTX7boXiT3StKNVbuOSppeEw7rogVRytdQR6ASZBAcQgfiy6qxoub0zDDjIjXiL1axx5luzqOxetZojCJdwqwCc5YvJT0M4R5D40gUiDkqTYa1iWTTdaMGEhCsuyucitZ1jZlrgarCtfQXGhSFqm87lnD_ZxjqSBY8lWODPiTAWQ\",\n" +
                "               \"width\" : 4640\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ5_bMsF89WBQRM7-YOesuHM8\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"3C7F+RV New Cairo City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H3C7F+RV\"\n" +
                "         },\n" +
                "         \"rating\" : 4.1,\n" +
                "         \"reference\" : \"CmRbAAAAR82sjpgju-eFl-egiFMSYod70vSV7Tcy-E7tQq3UFsWkOyZUiz3LqL-msDt5NaUYRskC0LI9hXfTKjYLTtraAb24pDUsu2ZR-fHB_2FeDOP0QtoJF-jV6JpWKQWyzo-wEhDz-zNqBcziJFoBAHZFQmV8GhRmUadOJCZW5thOA41P_sQXbd1L6g\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [\n" +
                "            \"shopping_mall\",\n" +
                "            \"movie_theater\",\n" +
                "            \"point_of_interest\",\n" +
                "            \"establishment\"\n" +
                "         ],\n" +
                "         \"vicinity\" : \"Cairo Governorate, Egypt\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 29.9776169,\n" +
                "               \"lng\" : 31.2843354\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 29.97903632989272,\n" +
                "                  \"lng\" : 31.28567237989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 29.97633667010728,\n" +
                "                  \"lng\" : 31.28297272010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"d075b1cc9693eae1f41ec2b12fb668785a4ea549\",\n" +
                "         \"name\" : \"El Bandar Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 3024,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/105097655142435906392/photos\\\"\\u003eIssa Khorrassany\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAR92C-WnAghXavVhsii2zoAw6KdBT0Dn2gyrYo3izxgkUgURBDm3G8vc0RNS3tB5czsf87Nhr9MfqUQAElGx5JpAGWn88_D1gnzvIDsaycNkZa076yRlFuPcTtyPZ4A5EEhD8A1Fpud5fjTYlnU_6vLRqGhQx7la1Xzufq6VmF9qXnJKWqLR10Q\",\n" +
                "               \"width\" : 4032\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJZ711I304WBQR_qX3YYECeWM\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"X7HM+2P Taqseem Laselky, Ezbet Fahmy, El-Basatin, Egypt\",\n" +
                "            \"global_code\" : \"7GXHX7HM+2P\"\n" +
                "         },\n" +
                "         \"rating\" : 3.9,\n" +
                "         \"reference\" : \"CmRbAAAAh8XAX05xLZrXY4Vut1MU5djwyIk3QbsldX76RSM0IPi7DT1prIwzg2MlfV7KmXuhIPOETIJlFdFhwBnxmNfpThMaBf95PAVYViYTzpvqmwa_VJpuOwV6ARu57mCP2OHuEhCvpR73X3ZbaFZkPBlQzAdJGhSM65Ww9Hs5QqVWUT6HIV6WYacVyQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"1 Palestine Rd, El-Basatin Sharkeya, Al Maadi\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.071877,\n" +
                "               \"lng\" : 31.2277144\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.07322682989272,\n" +
                "                  \"lng\" : 31.22906422989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.07052717010728,\n" +
                "                  \"lng\" : 31.22636457010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"e121dc3f04e10bbd506771ce6446f1d5058eed9b\",\n" +
                "         \"name\" : \"Renaissance Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 1520,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109664586309066319862/photos\\\"\\u003eYouhanna Awad\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAq0u19KW3AhjzRL27qMisukIAuSYvk4szrD0pync22EAElg3wNjqz9daxwAbNykocJvrrYigbYiJI6TYpQSLb7Lf2jgeKdhNbQC9ekbk1eK3acDVqVqwoplv2xViwZOLzEhAtfDk3qxba6X3DwP3wfxsOGhQACLw3xqJ6Ryex8CcIzRsnBUUlTw\",\n" +
                "               \"width\" : 2688\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJvQAu-vlAWBQRV3seDx_WxP8\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"36CH+Q3 Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H36CH+Q3\"\n" +
                "         },\n" +
                "         \"rating\" : 4.2,\n" +
                "         \"reference\" : \"CmRbAAAA3zEtfgKeyvh7-EHsZmu5fB1-tN5Yvk6P4fgF4A3XH0szLwkeXYsKThh13C6FoCUWmH92bUSnEa-dIiPzULNpfmC07iX6aJVnRAGJ1nRIW0SQjvEkQ3GR8dgV0iRGN_GdEhAcu_N4UlUuVR7c8m74V_A0GhTMaUgjX_RZA2blEfxpME7h0b2HFw\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Corniche El Nil، RAMLET BOULAK، Boulaq\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0725128,\n" +
                "               \"lng\" : 31.3463541\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.0760338,\n" +
                "                  \"lng\" : 31.34950665\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.07039739999999,\n" +
                "                  \"lng\" : 31.34400325000001\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"ea934fd2e3da5af398a2d644eca73d81b38cf746\",\n" +
                "         \"name\" : \"City Stars Cinema\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : false\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 529,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114061256424134738065/photos\\\"\\u003eAndrew Ashraf\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAxXh975G5BWbY_XVGVS8k5WhiqLI5LFy8BbzxRykAvp2Dri20q_yiORYRLb6U23HcdUCnxViq-0hYvXLkdP03gUcDDrxk753s7e_SkkigdO8-XiwdftfHOlDP3xZSFpfDEhCMDFeT1p-KrZuSOluzrODcGhRm58RbadoI1bEbz-25_HnX1efKfw\",\n" +
                "               \"width\" : 800\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJeQM7kA4-WBQRl3pI9iYM-BQ\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"38FW+2G Rabaa Buildings, Al Golf, Nasr City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H38FW+2G\"\n" +
                "         },\n" +
                "         \"rating\" : 4.4,\n" +
                "         \"reference\" : \"CmRbAAAAn7gviTMxlSi-hr8YBB7myO4iiSg37r9ScC2VvvvGckdylFchx6e4ICL9AHNv2cz7ncWk2vZCLXXBXxaiK4LH4TURQnH2pmQ_pQQvmNsenMj_705z6ThTNTn-HlxnH4evEhDf8-c2zXf631O7TzfJAVR3GhRJcNwID0VSbtEf4d1hCNsMks-_eg\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Masaken Al Mohandesin, Nasr City\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0923554,\n" +
                "               \"lng\" : 31.3224855\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.09363212989272,\n" +
                "                  \"lng\" : 31.32389272989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.09093247010728,\n" +
                "                  \"lng\" : 31.32119307010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"6d8cad9a174b671327adb5fcbecb5162d7a158eb\",\n" +
                "         \"name\" : \"Normandy Outdoor Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 464,\n" +
                "               \"html_attributions\" : [ \"A Google User\" ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAKSVD3LuFvlAKIgLdwhPHNz45ZWe-fpmRciIirrIxAASTG9tBkI0EGKHFJDgQHhs7SFY7Iz46T4JOpwQlhaejqSeKLTL5QcSgE0VZGBhCZEYopMXXmCW50bAz0nE86uv_EhCrZGOMY4pPfYemxhs8Wa8jGhSpwTJv6M3UienrGjyGYAK5_faNVA\",\n" +
                "               \"width\" : 800\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJVWkOpSc-WBQR_17XOii0rH4\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"38RC+WX Mansheya El-Bakry, Heliopolis, Egypt\",\n" +
                "            \"global_code\" : \"8G2H38RC+WX\"\n" +
                "         },\n" +
                "         \"rating\" : 3.4,\n" +
                "         \"reference\" : \"CmRbAAAAxwxxaQfNR1iqTtPdZhTj8K9llt9jWy9soIFjUmofgZZaPg7NYYLjENlt6bg8egJTnkwBXPEaPxUXJ_DpGoMtgozOFq9qBt8v7jZn0L1f4PVQ8lGHY2w6r-enSZr8irWTEhDK6ZOfQOIkNlYczSaVinzHGhTxESdHRKhoCqY7zYLlGe6ucKqGrQ\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"32 Al Ahram, El-Montaza, Heliopolis\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0795678,\n" +
                "               \"lng\" : 31.4544076\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.08091762989272,\n" +
                "                  \"lng\" : 31.45575742989271\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.07821797010728,\n" +
                "                  \"lng\" : 31.45305777010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"5a910207bce51ef124b674acea39617070a27cff\",\n" +
                "         \"name\" : \"Mirage Mall Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 1080,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/110958125188174287107/photos\\\"\\u003eehab gamal\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAZdrTkYJDc0ekwnTnsC5iI2_noocgo9stgItbRuv8g9KB6p9rlLBfL6GnzCnhBQ-I9sJ7qLYGaLcGHT92rPTZOYn5TSzmdJNNgIRQJ9qGWmzZrbZj4dgmgw5RKkfKuc9FEhAcQW-q9FCmSSSKZKL3fooHGhTp0VteaT2LtJv69XHC-XiGqdoLWQ\",\n" +
                "               \"width\" : 1920\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJ2YB2x1I9WBQRADuVlU01yXY\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"3FH3+RQ New Cairo City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H3FH3+RQ\"\n" +
                "         },\n" +
                "         \"rating\" : 4.2,\n" +
                "         \"reference\" : \"CmRbAAAA_FZM2mkM-KicO6SEixEnnLYhAWqKr1frwE0MtFfMSVkDgO6RvVj0J7gMiAtc5soEelfj-XznflZUvL0NUk2FEx7WSlUf2Hp30S9ws04_18-hbR9Ipx51BiG7kpbPYDHrEhA7zHBnV_h7kk24zqg2o8xQGhS7jjZoG1GupFjPiHwcqnnMWbVSrw\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Moustafa Kamel Axis\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0610125,\n" +
                "               \"lng\" : 31.2196126\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.06236232989272,\n" +
                "                  \"lng\" : 31.22096242989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.05966267010728,\n" +
                "                  \"lng\" : 31.21826277010727\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"c202d2bf86780f00b58e1e59eae471029f7fb76d\",\n" +
                "         \"name\" : \"Cairo Palace Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 2560,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/108965752244435400391/photos\\\"\\u003eNesreen Mamoun\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAJsjlLIvQn2iHy70EEIl1IYfJtUpw7jWm_UzsBRYHkvMn41ZBNQUhAUAV8glKP4ssWDtgzheZbEEw6D13rB6zAzpuyvD2Ufe4ER9fycadqQt5gRL_kPeyKk2dNpZsK8PrEhD8Zf6Co_OSAgQkepQqKrTaGhTCvzX2-F0CHfMnCR5xEcUCVE9Dvw\",\n" +
                "               \"width\" : 1920\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJo5Qz_eBAWBQRq50UVxu-W0U\",\n" +
                "         \"rating\" : 3.4,\n" +
                "         \"reference\" : \"CmRbAAAATCesm0Q_AELvZs-_tr3EsAEX6Hh0AxbNbuwXrOcPeZCC6M5Jx-iW8Yw5p9cVW-obCM_osOmVZ2_rUJmgz8FG8gIbhe_k71wAzHKxmqr1RQPjxAoae7tUr7I1IB-bNr3IEhCdqAExSJzIhHuEe-mhp9ayGhSqmlq_dCaIh-3c2B7SEudUkpnu1g\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"ش 26 يوليو، وسط البلد، Zamalek\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.1644284,\n" +
                "               \"lng\" : 31.5569857\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.16577822989272,\n" +
                "                  \"lng\" : 31.55833552989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.16307857010728,\n" +
                "                  \"lng\" : 31.55563587010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"82e5f052b3fcaf0e615eaae020dc6a329bae6272\",\n" +
                "         \"name\" : \"Future Cinema\",\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 2448,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/101756043988081722868/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAI_ICYBRdzK22Lq6nzw9xMifH8RPr3Yqf-0dura_qDvqdghSI7k84MWPXSx7GcqaMiZVdGjKMGj2PZBKeys7Cm7dOHYZXFn13pSmOIoaX5H_MyS0bMpoHNM8RKf3bcP4lEhAdjrdoA-v0mRB08t5zgVGdGhQroh7gZruWdTbrlxBfxaTbyxpjVA\",\n" +
                "               \"width\" : 3264\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJsU74B40cWBQRrtVIgHVg7Po\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"5H74+QQ Future City, Egypt\",\n" +
                "            \"global_code\" : \"8G2H5H74+QQ\"\n" +
                "         },\n" +
                "         \"rating\" : 3.8,\n" +
                "         \"reference\" : \"CmRbAAAA_AbwlwBjC7gp2KpfO90Zw1nAg6jz-vVo2TEiFWgtcAdBZSu4MSgHc3SHMtgl13ECtimubcjM04QfuwzmPbciA0DBK-cpObEkFz-qgn34TqI4josYoFHdbj1kUHXoSG3eEhBLYXUCgdHIFNqszh6qtUfEGhTyaTK72FSOA9HLzj8ekF1ozawkfA\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"Cairo Governorate, Egypt\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"geometry\" : {\n" +
                "            \"location\" : {\n" +
                "               \"lat\" : 30.0557729,\n" +
                "               \"lng\" : 31.2442505\n" +
                "            },\n" +
                "            \"viewport\" : {\n" +
                "               \"northeast\" : {\n" +
                "                  \"lat\" : 30.05712502989272,\n" +
                "                  \"lng\" : 31.24562832989272\n" +
                "               },\n" +
                "               \"southwest\" : {\n" +
                "                  \"lat\" : 30.05442537010728,\n" +
                "                  \"lng\" : 31.24292867010728\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
                "         \"id\" : \"e30df168d9f7216985a59e1af2018b443dd23d3b\",\n" +
                "         \"name\" : \"Zawya Cinema\",\n" +
                "         \"opening_hours\" : {\n" +
                "            \"open_now\" : true\n" +
                "         },\n" +
                "         \"photos\" : [\n" +
                "            {\n" +
                "               \"height\" : 2560,\n" +
                "               \"html_attributions\" : [\n" +
                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/108224934281108765752/photos\\\"\\u003eميدو مشاكل\\u003c/a\\u003e\"\n" +
                "               ],\n" +
                "               \"photo_reference\" : \"CmRaAAAAqV7HEp0kklV1ntfDODrXCr8OI-d7271xKjm7LZFhqr9mpVb0Jt3OL5nAaSvUQQOjLvPrakOUA0jQbYvd8l430JNTTk6IsSDoNHxcR6oYmNxZfTZsa5jFt05sZNRTqXI2EhBl0MMSwPyX6Id4RulVKn0uGhRnWh0PPRDpnPZoVPQWkUHe2U8Frg\",\n" +
                "               \"width\" : 1536\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\" : \"ChIJw44Z2LlAWBQReWWURWDzERM\",\n" +
                "         \"plus_code\" : {\n" +
                "            \"compound_code\" : \"364V+8P Cairo, Egypt\",\n" +
                "            \"global_code\" : \"8G2H364V+8P\"\n" +
                "         },\n" +
                "         \"rating\" : 4,\n" +
                "         \"reference\" : \"CmRbAAAA8SimcnCVFL1Wkl3Hzb9dR_WBiIKvQOdqEqeN-9Ea4O6nkGZKm44aVp7ejVhphM7xzyBUtWj3tr0VG7vk3aVFuwSl8pSIy0-klybt-XQa1oJQ3WrPWK6niLl_tAJ5VO2zEhCyJy2azd-X6ikuuxu1IfU8GhRCLceR0Y0XgiLEx868vSZ7C5kkUw\",\n" +
                "         \"scope\" : \"GOOGLE\",\n" +
                "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
                "         \"vicinity\" : \"15 شارع عماد الدين وسط البلد القاهرة القاهرة EG 11522، 15 Emad El-Deen, Oraby, Al Azbakeyah\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"status\" : \"OK\"\n" +
                "}";

        Cinemas(json);

//

    }


    public void Cinemas(String json) {

        cinPlaces = new ArrayList<cinPlace>();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = jsonArray.getJSONObject(i);
                JSONObject geo = c.getJSONObject("geometry");
                JSONObject loc = geo.getJSONObject("location");
//                JSONObject plus_code = c.getJSONObject("plus_code");

                cinPlaces.add(new cinPlace(c.getString("icon"),
                        c.getString("id"),
                        c.getString("name"),
                        loc.getString("lat"),
                        loc.getString("lng"),
                        c.getString("place_id"),
                        c.getString("rating"),
                        c.getString("reference"),
                        c.getString("vicinity")
                ));
                Log.e("cinemas", "" + cinPlaces.size());
                createList(cinPlaces);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void createList(final ArrayList<cinPlace> cinPlaces) {

        ListView listView = (ListView) findViewById(R.id.cinemaslist);
        cinAdapter cinAdapter = new cinAdapter(cinPlaces, getApplicationContext());
        listView.setAdapter(cinAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_LONG).show();
                String url = "https://maps.googleapis.com/maps/api/directions/json?origin=30.06236232989272,31.22096242989272&destination=30.16577822989272,31.55833552989272&key=AIzaSyCkcxUa8VMUJxbkRYKpauQjaYCGcsZt-yI";
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        https://maps.googleapis.com/maps/api/directions/json?origin=30.06236232989272,31.22096242989272&destination=30.16577822989272,31.55833552989272&key=AIzaSyCkcxUa8VMUJxbkRYKpauQjaYCGcsZt-yI
//                        here using the api but it needs paying
                        
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("http://maps.google.com/maps?daddr=" + cinPlaces.get(position).lat + "," + cinPlaces.get(position).lng));
                        startActivity(intent);
                        Log.e("mohamed direction", "" + response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "sorry connection failed", Toast.LENGTH_LONG).show();
                    }
                });


                requestQueue.add(stringRequest);
            }


        });
    }


    public void getjsonbyurl() {
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=30.05,31.14&radius=185000&type=cinema&keyword=cinema&key=AIzaSyCkcxUa8VMUJxbkRYKpauQjaYCGcsZt-yI";
////
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mousaaaaaaa", "" + response);

                Cinemas(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "sorry connection failed", Toast.LENGTH_LONG).show();
            }
        });


        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loc:
                getjsonbyurl();
                break;
            case R.id.locs:
                startActivity(new Intent(getApplicationContext(), MapsActivity.class).putParcelableArrayListExtra("cinemas", cinPlaces));
                break;
            case R.id.home2:
                startActivity(new Intent(getApplicationContext(), moviesShow.class));
                break;
        }
    }
}
