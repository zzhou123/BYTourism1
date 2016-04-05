package com.ezz.bytourism1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import com.ezz.bean.User;

import java.util.List;

/**
 * Created by johnchen on 16/4/4.
 */
public class LoginActivity extends BaseActivity{
    Button login,register;
    EditText username,password;
    String usernameStr,passwordStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Bmob.initialize(LoginActivity.this,"a1a4ff643e92be99bb8649e33589c596");
        //DOM��
        login = (Button) findViewById(R.id.button1);
        register = (Button) findViewById(R.id.button2);
        username = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);

        //��½����
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ȡ�˺�����
                usernameStr = username.getText().toString();
                passwordStr = password.getText().toString();
                if(!usernameStr.isEmpty() && !passwordStr.isEmpty()){
                    //�ύ����
                    BmobQuery<User> query = new BmobQuery<User>();

                    query.addWhereEqualTo("username", usernameStr);
                    query.addWhereEqualTo("password", passwordStr);
                    query.findObjects(LoginActivity.this, new FindListener<User>() {

                        @Override
                        public void onSuccess(List<User> list) {
                            User user = list.get(0);
                            String id1 = user.getId();
                            String id = id1.substring(0,id1.length()-2);

                            if(!id.isEmpty()){
                                savePreference(USER_ID,id);
                                savePreference(USER_NAME,usernameStr);
                                Intent intent = new Intent(LoginActivity.this,Personal_centerActivity.class);  //����1
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onError(int code, String msg) {
                            // TODO Auto-generated method stub
                            Toast.makeText(LoginActivity.this, "�˺Ż�������������,���������"+msg, Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this, "123error", Toast.LENGTH_SHORT).show();

                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);  //����1
                startActivity(intent);
            }
        });
    }
    public void regist(){
        Intent intent = new Intent(LoginActivity.this,RegistActivity.class);  //����1
        startActivity(intent);
    }
}
