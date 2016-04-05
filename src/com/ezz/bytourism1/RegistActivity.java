package com.ezz.bytourism1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import com.ezz.bean.User;

import java.util.List;

/**
 * Created by 37492 on 2016/4/4.
 */
public class RegistActivity extends BaseActivity{
    private String username,password,repassword,realname,telphone,school,email,intro,sex,label="";
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO �Զ����ɵķ������
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);
        Bmob.initialize(RegistActivity.this, "a1a4ff643e92be99bb8649e33589c596");


    }

    public void registsubmit(View view){
        EditText uname = (EditText)findViewById(R.id.username);
        EditText pwd = (EditText)findViewById(R.id.password);
        EditText repwd = (EditText)findViewById(R.id.repassword);
        EditText realn = (EditText)findViewById(R.id.realname);
        EditText uage = (EditText)findViewById(R.id.age);
        EditText utel = (EditText)findViewById(R.id.telphone);
        EditText uschool = (EditText)findViewById(R.id.school);
        EditText uemail = (EditText)findViewById(R.id.email);
        EditText uintro = (EditText)findViewById(R.id.intro);

        RadioGroup temp = (RadioGroup)findViewById(R.id.sex);
        RadioButton usex = (RadioButton)findViewById (temp.getCheckedRadioButtonId());
//        temp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//            //������������������ı�ѡ���radioButton����ֵ���Լ�����ֵ��ص� //�κβ������������
//               // selectRadioBtn();
//            }
//        });

        CheckBox c1 = (CheckBox)findViewById(R.id.label1);
        //CheckBox c2 = (CheckBox)findViewById(R.id.label2);
        //CheckBox c3 = (CheckBox)findViewById(R.id.label3);
        username = uname.getText().toString();
        password = pwd.getText().toString();
        repassword = repwd.getText().toString();
        realname = realn.getText().toString();
        sex = usex.getText().toString();
        if(!uage.getText().toString().isEmpty()){
            age = Integer.parseInt(uage.getText().toString());
        }
        telphone = utel.getText().toString();
        school = uschool.getText().toString();
        email = uemail.getText().toString();
        intro = uintro.getText().toString();

        if(c1.isChecked()){
            label = c1.getText().toString()+label;
        }
//        if(c2.isChecked()){
//            label = c2.getText().toString()+label;
//        }
//        if(c3.isChecked()){
//            label = c3.getText().toString()+label;
//        }

        if(username.equals("")|password.equals("")|repassword.equals("")){
            Toast.makeText(RegistActivity.this,"�ǳƻ����벻��Ϊ��",Toast.LENGTH_LONG).show();
        }
        else if(!password.equals(repassword)){
            Toast.makeText(RegistActivity.this,"�������벻һ��",Toast.LENGTH_LONG).show();
        }
        else {


            BmobQuery<User> query = new BmobQuery<User>();
            query.addWhereEqualTo("username", username);

            query.findObjects(RegistActivity.this, new FindListener<User>() {

                @Override
                public void onSuccess(List<User> list) {
                   // if (list.get(0).getUsername().equals(username)) {
                    Toast.makeText(RegistActivity.this, list.get(0).getUsername(), Toast.LENGTH_LONG).show();
                    Toast.makeText(RegistActivity.this, "�û��ǳ��ѱ�ʹ�ù������޸��û��ǳ�", Toast.LENGTH_LONG).show();

                }
                @Override
                public void onError(int code, String msg) {
                    // TODO Auto-generated method stub
                    Toast.makeText(RegistActivity.this, "�ǳƿ���ʹ��", Toast.LENGTH_LONG).show();
                    User userObj = new User();
                    userObj.setUsername(username);
                    userObj.setPassword(password);
                    userObj.setRealname(realname);
                    userObj.setAge(age);
                    userObj.setSex(sex);
                    userObj.setEmail(email);
                    userObj.setSchool(school);
                    userObj.setTelphone(telphone);
                    userObj.setIntro(intro);
                    userObj.setLabel(label);
                    userObj.save(RegistActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            savePreference(USER_NAME,username);
                            BmobQuery<User> queryId = new BmobQuery<User>();
                            queryId.addWhereEqualTo("username", username);

                            queryId.findObjects(RegistActivity.this, new FindListener<User>() {
                                @Override
                                public void onSuccess(List<User> list) {
                                    String userid1 = list.get(0).getId();
                                    String userid = userid1.substring(0,userid1.length()-2);
                                    savePreference(USER_ID,userid);
                                    Intent intent = new Intent(RegistActivity.this,Personal_centerActivity.class);  //����1
                                    startActivity(intent);
                                    Toast.makeText(RegistActivity.this, "ע��ɹ�", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onError(int i, String s) {
                                    Toast.makeText(RegistActivity.this, "Perferenceʧ��:"+s, Toast.LENGTH_LONG).show();
                                }
                            });


                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(RegistActivity.this, "ע��ʧ��:"+s, Toast.LENGTH_LONG).show();

                        }
                    });
                }
            });


        }
    }
}
