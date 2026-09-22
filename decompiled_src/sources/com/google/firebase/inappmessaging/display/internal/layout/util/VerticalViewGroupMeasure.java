package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class VerticalViewGroupMeasure {
    private int h;
    private List<ViewMeasure> vms;
    private int w;

    public VerticalViewGroupMeasure(int i, int i2) {
        this.vms = new ArrayList();
        this.w = i;
        this.h = i2;
    }

    public VerticalViewGroupMeasure() {
        this.vms = new ArrayList();
        this.w = 0;
        this.h = 0;
    }

    public void reset(int i, int i2) {
        this.w = i;
        this.h = i2;
        this.vms = new ArrayList();
    }

    public void add(View view, boolean z) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z);
        viewMeasure.setMaxDimens(this.w, this.h);
        this.vms.add(viewMeasure);
    }

    public List<ViewMeasure> getViews() {
        return this.vms;
    }

    public int getTotalHeight() {
        Iterator<ViewMeasure> it = this.vms.iterator();
        int desiredHeight = 0;
        while (it.hasNext()) {
            desiredHeight += it.next().getDesiredHeight();
        }
        return desiredHeight;
    }

    public int getTotalFixedHeight() {
        int desiredHeight = 0;
        for (ViewMeasure viewMeasure : this.vms) {
            if (!viewMeasure.isFlex()) {
                desiredHeight += viewMeasure.getDesiredHeight();
            }
        }
        return desiredHeight;
    }

    public void allocateSpace(int i) {
        float f;
        ArrayList<ViewMeasure> arrayList = new ArrayList();
        for (ViewMeasure viewMeasure : this.vms) {
            if (viewMeasure.isFlex()) {
                arrayList.add(viewMeasure);
            }
        }
        Collections.sort(arrayList, new Comparator<ViewMeasure>() { // from class: com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure.1
            @Override // java.util.Comparator
            public int compare(ViewMeasure viewMeasure2, ViewMeasure viewMeasure3) {
                if (viewMeasure2.getDesiredHeight() > viewMeasure3.getDesiredHeight()) {
                    return -1;
                }
                return viewMeasure2.getDesiredHeight() < viewMeasure3.getDesiredHeight() ? 1 : 0;
            }
        });
        Iterator it = arrayList.iterator();
        int desiredHeight = 0;
        while (it.hasNext()) {
            desiredHeight += ((ViewMeasure) it.next()).getDesiredHeight();
        }
        int size = arrayList.size();
        if (size >= 6) {
            throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        }
        float f2 = 1.0f - ((size - 1) * 0.2f);
        Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2f, f2);
        float f3 = 0.0f;
        for (ViewMeasure viewMeasure2 : arrayList) {
            float desiredHeight2 = viewMeasure2.getDesiredHeight() / desiredHeight;
            if (desiredHeight2 > f2) {
                f3 += desiredHeight2 - f2;
                f = f2;
            } else {
                f = desiredHeight2;
            }
            if (desiredHeight2 < 0.2f) {
                float fMin = Math.min(0.2f - desiredHeight2, f3);
                f3 -= fMin;
                f = desiredHeight2 + fMin;
            }
            Logging.logdPair("\t(desired, granted)", desiredHeight2, f);
            viewMeasure2.setMaxDimens(this.w, (int) (f * i));
        }
    }
}
