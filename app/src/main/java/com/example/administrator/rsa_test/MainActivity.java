package com.example.administrator.rsa_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.rsa_test.util.Base64Helper;
import com.example.administrator.rsa_test.util.Base64Util;
import com.example.administrator.rsa_test.util.MyUtil;
import com.example.administrator.rsa_test.util.RSA.RSAUtil;
import com.example.administrator.rsa_test.util.RsaHelper;
import com.example.administrator.rsa_test.util.RsaUtil;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

public class MainActivity extends AppCompatActivity {

    private EditText mEtContent;
    private TextView mTvEncode;
    private TextView mTvDencode;
    private TextView mTvJavaToCPublic;
    private TextView mTvJavaToCPrivate;
    private Button mBtnEncode;
    private Button mBtnDecode;
    private static final String strPublicKey = "<RSAKeyValue><Modulus>AO+Kx+uK5abJ28azeUlqMRuCYX97X5LnVk12pdTi2CKIRm9mLE/sDMRDqmPZ+O23HF74nd9tu2i74Jdd7R+88iYvgvq1H2unVTteW3E7fFqRR9gl+th3q2dP5nn0vd1VANTwYYj/TnguXjpgcrEOq9pjzbSHmpVbnpSJD27Y4F3b</Modulus><Exponent>AQAB</Exponent></RSAKeyValue>";
    private static final String strPrivateKey = "<RSAKeyValue><Modulus>AO+Kx+uK5abJ28azeUlqMRuCYX97X5LnVk12pdTi2CKIRm9mLE/sDMRDqmPZ+O23HF74nd9tu2i74Jdd7R+88iYvgvq1H2unVTteW3E7fFqRR9gl+th3q2dP5nn0vd1VANTwYYj/TnguXjpgcrEOq9pjzbSHmpVbnpSJD27Y4F3b</Modulus><Exponent>AQAB</Exponent><P>APhQY5NP7qi926nbLMRjcIIvGWJqvVmRN7nGyvQD5PSQHrqxVcnX9LoPLt0v73iQmHcezqJttQsQTSJoPSXyYA0=</P><Q>APb04mlE3pFiCgcZZYAzd5yNA9V32BH5CCiH/VTghpAg6ochviRV92BlP8uXQUxPRDJv1m8IAti2UMd6vuY504c=</Q><DP>YgysJQENBghh8oIe/TUeuekLJvdq6TEURgEfJpdbEs7Ns35Ol7L0aXuRT7mb34mJCpBZm32iXUoEiy+J5a/9CQ==</DP><DQ>XbkCVEE21qYGeDtDMixWMKuz0Mfy0J9aYUd69UNgzkIvv6kmqFOX1pWWaIW22mca0qlvECRSMDzA23PSDz3S8Q==</DQ><InverseQ>AM0GM3zPygiOM4yM9Ei17nB1CIelUBCludwuoBRinbh8icvi38pBz0xBIpPHpBXs6T8u7uwixOEcE8QpplN/ftU=</InverseQ><D>BJvp/tk8U/o8VVVstwHpEftvPtGz5BK5cWIgDLmUqQ1wNYKExcDn+frHU4aFKKXGUPl9qCfnXDuJNcBj6KFtE099IHYQjL3TMePVP+MGRS55C866/sdD+As+yPdihrMYZfXk3dHHi4pyjC3ridthpm8n+XcvfGdq617irw7LRKk=</D></RSAKeyValue>";

    private String content2 = "ANhUlRwtfFdfCnddKVxlXZ52rqd4uJSEB1KP23bOmwQOFBRs8+g3vewSRBFwhMQXSlPq8V1iEil/iSc5XMXshCMgRYKRpvMxikxuLBPYfylsynizdOhveFy9nt0C4bTBeKKQja4QS1lclZeXnhb48RijUkHMk7sz3/WqZGdi+J15";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mEtContent = (EditText) findViewById(R.id.et_content);
        mTvEncode = (TextView) findViewById(R.id.tv_encode_content);
        mTvDencode = (TextView) findViewById(R.id.tv_dencode_content);
        mTvJavaToCPublic = (TextView) findViewById(R.id.tv_publicKey_JavaToC);
        mTvJavaToCPrivate = (TextView) findViewById(R.id.tv_private_JavaToC);
        mBtnEncode = (Button) findViewById(R.id.btn_encode);
        mBtnDecode = (Button) findViewById(R.id.btn_decode);
        mBtnEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyPair mKeyPair = RsaUtil.generateRSAKeyPair(1024);
                Log.i("===mTvJavaToCPrivate_XML===》", RsaHelper.encodePrivateKeyToXml(mKeyPair.getPrivate()));
                System.out.print("mTvJavaToCPrivate_XML:" + RsaHelper.encodePrivateKeyToXml(mKeyPair.getPrivate()));
                Log.i("===mTvJavaToCPublic_XML===》", RsaHelper.encodePublicKeyToXml(mKeyPair.getPublic()));
                System.out.print("mTvJavaToCPublic_XML:" + RsaHelper.encodePublicKeyToXml(mKeyPair.getPublic()));
                Log.i("===mTvJavaToCPrivate_Base64_2===》", Base64Util.encode(mKeyPair.getPrivate().getEncoded()));
                System.out.print("mTvJavaToCPrivate_Base64_2:" + Base64Util.encode(mKeyPair.getPrivate().getEncoded()));
                Log.i("===mTvJavaToCPublic_Base64_2===》", Base64Util.encode(mKeyPair.getPublic().getEncoded()));
                System.out.print("mTvJavaToCPrivate_Base64_2:" + Base64Util.encode(mKeyPair.getPublic().getEncoded()));
                mTvJavaToCPrivate.setText(RsaHelper.encodePrivateKeyToXml(mKeyPair.getPrivate()));
                mTvJavaToCPublic.setText(RsaHelper.encodePublicKeyToXml(mKeyPair.getPublic()));
                String planitText = "123";
                try {
                    String rs1 = Base64Util.encode(RsaUtil.encryptByPublicKey(planitText.getBytes("UTF-8"), mKeyPair.getPublic().getEncoded()));
                    Log.e("===加密1===>", rs1);
                    String rs2 = Base64Util.encode(RsaUtil.encryptByPublicKey(planitText.getBytes("UTF-8"), mKeyPair.getPublic()));
                    Log.e("===加密2===>", rs2);
                    String rs1_d1 = new String(RsaUtil.decryptByPrivateKey(Base64Util.decode(rs1), mKeyPair.getPrivate().getEncoded()), "UTF-8");
                    Log.e("===解密—rs1_d：===>", rs1_d1);
                    String rs1_d2 = new String(RsaUtil.decryptByPrivateKey(Base64Util.decode(rs1), mKeyPair.getPrivate()), "UTF-8");
                    Log.e("===解密—rs1_d2：===>", rs1_d2);
                    String rs2_d1 = new String(RsaUtil.decryptByPrivateKey(Base64Util.decode(rs2), mKeyPair.getPrivate().getEncoded()), "UTF-8");
                    Log.e("===解密—rs2_d：===>", rs2_d1);
                    String rs2_d2 = new String(RsaUtil.decryptByPrivateKey(Base64Util.decode(rs2), mKeyPair.getPrivate()), "UTF-8");
                    Log.e("===解密—rs2_d2：===>", rs2_d2);
                    /******************* 另一个工具 *************************************/
                    String pT = "oG5zQTpfJ+2o0NPnI+abkYidOYlXFFIHqf7g1Y5txmUifoIpiHgy1WDKsT+tnByR6kXVZd7NymD0powqTMrSB8nV30GlRGx8gAQ4k8o1iOw/M1Z5E7ydOiYhW901LwJJX6Z8oDCgDUcXGP7VeYMt4/GEl2F65sY2sz2jmivf5xQ=";
                    String pK = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMajgrAF07zq1iZIqYgff+QQrwS2+hmHy4c4pHITspBEJwH4pNRI4QU5+d07roLU9FkyubG9Thc7hwGYtnBIXvpTC2byQnxvvzHZf7OXUvIRCp2XR471hDUsDkJHp2wc3gXD0AKmzaPQMDWd33SNYz56tZrptbTfFtiXkyVXHNkXAgMBAAECgYAxDkaDJB1DhZd3gvBjTqwt7bTbbDjdvzyTW3i5N4YcvMgJY5eJWapAuS2s5kVVyDPEJ5PWglLbx/ayfT1pA2Z46kXnJr3AFvpC6Q3OB9XtBGhd42liipVKoScuIxpZ+0Yi7gc7eM2tg9k71A0uIoRRxmxVD1CzvUqju5unFiM3UQJBAOgO1ohnrqF+rlLVmiqBtU1PLtsAF5SDtQ0rfPTrJ/Zidw9Fa9hEk66CLPIIgcq+fTfKBi8r8xh6Gq2f5Irolu8CQQDbIf8bd3WVBSdm9KTf2xwMrLO/wS4FBzAQLc126tCMiGXQvZ99ZCgaG35QfuQ2n4/ynXPdxD9tVaCyHBT4xaBZAkEAmEdUZIKVSAiXYGgnGImxbZ/ugWvYDW84WgIVp6rAuJ/4vR6zHGIz/yoRUGpgsai7Bucdk8rlZUSLSTBJixYCJQJAbprHP97ZC4GRdMbw3Uij7MXS6GuiRclt+gyUU3yMDRLfiS/c65Z9I0hTRl/14phBOO0+SWY/uXjp5lyEPVjK6QJBAKwQKnDvO/whdpClK3GF3j3/dQKv78aUtWQbptEs9WnJoxn4dB5B5SpEvdOXmoEio3UcCptvxSpDaT8b43INryE=";
                    byte[] pk_base64 = Base64Util.decode(pK);
                    String result = new String(RsaUtil.decryptByPrivateKey(Base64Util.decode(pT), pk_base64), "UTF-8");
                    Log.e("====>", result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mBtnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String privateForC = strPrivateKey;
//                String privateForC =mTvJavaToCPrivate.getText().toString().trim();
                PrivateKey privateKey = RsaHelper.decodePrivateKeyFromXml(privateForC);
//                String content = mTvEncode.getText().toString().trim();
                try {
//                    String result = new String(RsaHelper.decryptData(Base64Helper.decode(content) , privateKey) , "UTF-8");
                    String result = new String(RsaHelper.decryptData(Base64Helper.decode(content2), privateKey), "UTF-8");
                    mTvDencode.setText(result);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
