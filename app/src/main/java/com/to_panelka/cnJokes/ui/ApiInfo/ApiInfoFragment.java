package com.to_panelka.cnJokes.ui.ApiInfo;

import android.webkit.WebView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.to_panelka.cnJokes.R;

public class ApiInfoFragment extends Fragment {

  private ApiInfoViewModel mViewModel;

  //public static ApiInfoFragment newInstance() {
 //   return new ApiInfoFragment();
  //}

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_api_info, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    WebView webView = view.findViewById(R.id.web_browser);
    webView.loadUrl("http:www.icndb.com/api/");
  }
}