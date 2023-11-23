package com.ghj.jeonjutour.activity.viewmodel;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ghj.jeonjutour.dto.CultureExpDto;
import com.ghj.jeonjutour.dto.DetailData;

public class DetailViewModel extends ViewModel {

    public MutableLiveData<DetailData> detailData = new MutableLiveData<>();
    // 문화체험
    public void setCEItem(CultureExpDto.CEItem item) {
        if(item == null) return;

        DetailData data = new DetailData();
        data.title = item.dataTitle;
        data.address = item.addr + " " + item.addrDtl;
        data.contents = item.dataContent;
        if(!TextUtils.isEmpty(item.zipcode)) {
            data.fullAddress = item.addr + " " + item.addrDtl + "\n(" + item.zipcode + ")";
        }
        else {
            data.fullAddress = item.addr + " " + item.addrDtl;
        }
        data.tel = item.tel;
        data.homepage = item.homepage;
        detailData.setValue(data);
    }

}
