package com.ezz.bytourism1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by johnchen on 16/4/4.
 */
public class BaseActivity  extends Activity{

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO
        super.onCreate(savedInstanceState);

    }

    /**
     * ���˴ε�½���˻���Ϣ�洢����
     * */
    protected void savePreference(String key , String value) {
        // ��ȡSharedPreference
        SharedPreferences preference = getSharedPreferences("android",
                MODE_PRIVATE);
        // ��ȡeditor
        SharedPreferences.Editor editor = preference.edit();
        // ��������
        editor.putString(key, value);
        // �ύ�����ļ���
        editor.commit();
    }
    /**
     * ��ȡ����SharedPreference�е��˻�
     *
     * @return
     * */
    protected String getPreference(String key) {
        // ��ȡSharedPreference
        SharedPreferences preference = getSharedPreferences("android",
                MODE_PRIVATE);
        // ��ȡ����SharedPreference�е��û���
        return  preference.getString(key, "");

    }
    protected void deletePreference() {
        // ��ȡSharedPreference
        SharedPreferences preference = getSharedPreferences("android",
                MODE_PRIVATE);
        // ��ȡeditor
        SharedPreferences.Editor editor = preference.edit();
        // ��������
        editor.putString(USER_ID,"");
        editor.putString(USER_NAME,"");
        // �ύ�����ļ���
        editor.commit();
    }
}
