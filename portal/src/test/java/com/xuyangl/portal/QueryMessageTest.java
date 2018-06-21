package com.xuyangl.portal;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/29 14:52
 */
public class QueryMessageTest {

    @Test
    public void queryMessage() throws ClientException {
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化ascClient需要的参数
        final String product = "Dysmsapi";  //短信产品API名称（短信产品名固定，无需更改）
        final String domain = "dysmsapi.aliyuncs.com";  //短信API产品于明加（接口地址固定，无需更改）

        //AccessKeyId
        final String accessKeyId = "LTAIGO4GXa8Srh0q";
        final String accessKeySecret = "k4OffTBQRkFj9TwVAiJiOAYCKvogfZ";

        //初始化ascClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();

        //必填-号码
        request.setPhoneNumber("18392150502");
        //可选-调用发送短信接口时返回的BizId
        request.setBizId("1234567^8901234");
        //必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
        request.setSendDate("20180529");

        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始
        request.setCurrentPage(1L);


        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
        if (querySendDetailsResponse.getCode()!=null&&querySendDetailsResponse.getCode().equalsIgnoreCase("OK"))
        {
            List<QuerySendDetailsResponse.SmsSendDetailDTO> smsSendDetailDTOs = querySendDetailsResponse.getSmsSendDetailDTOs();
            smsSendDetailDTOs.forEach(smsSendDetailDTO -> {
                System.out.println(smsSendDetailDTO.getContent());
            });
        }
    }
}
