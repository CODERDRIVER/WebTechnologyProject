package com.xuyangl.portal;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.Test;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/29 10:32
 */
public class SendMessageTest {

    @Test
    public void test() throws ClientException {
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout","10000");
        System.setProperty("sun.net.client.defaultReadTimeout","10000");

        //初始化ascClient需要的参数
        final String product = "Dysmsapi";  //短信产品API名称（短信产品名固定，无需更改）
        final String domain = "dysmsapi.aliyuncs.com";  //短信API产品于明加（接口地址固定，无需更改）

        //AccessKeyId
        final String accessKeyId = "LTAIGO4GXa8Srh0q";
        final String accessKeySecret = "k4OffTBQRkFj9TwVAiJiOAYCKvogfZ";

        //初始化ascClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();

        //使用post提交
        request.setMethod(MethodType.GET);
        /**
         * 待发送手机号，支持以逗号分隔的形式进行批量调用，批量上限为
         * 1000个手机号码，批量调用相对于单挑调用及时性稍有延迟，验证码类型的短信推荐
         * 使用单条调用的方式；
         * 发送国际/港澳台信息时，接受号码个事为00+国家区号+号码
         */
        request.setPhoneNumbers("18392150502");

        //短信签名
        request.setSignName("刘旭阳");
        //短信模板
        request.setTemplateCode("SMS_136090013");

        /**
         * 可选，模板中的变量替换JSON串，如模板内容中
         * "亲爱的${name},您的验证码为${code}"时，此处的值为
         *
         */
        request.setTemplateParam("{\"code\":\"123\"}");

        //可选-上行短信扩展码（扩展码控制在7位以下，无特殊需求用户请忽略此字段）
//        request.setSmsUpExtendCode("");

        //可选：outId为提供给业务方扩展字段，最终在短信回执信息中将此值待会给调用者
//        request.setOutId("yourOutId");
        //请求失败会抛出ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println(sendSmsResponse.getCode());
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equalsIgnoreCase("OK")) {
            System.out.println("发送成功");
        }
    }
}
