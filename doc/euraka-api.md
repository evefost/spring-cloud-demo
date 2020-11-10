
## eureka api 文档
    https://github.com/Netflix/eureka/wiki/Eureka-REST-operations
    
## 注册
    http://localhost:8762/eureka/apps/EUREKA-CLIENT232
    
    <instance>
        <instanceId>eureka-client:ee11acdbe8861d2fb34be72f992d83</instanceId>
        <hostName>192.168.3.11</hostName>
        <app>EUREKA-CLIENT232</app>
        <ipAddr>192.168.3.11</ipAddr>
        <status>UP</status>
        <overriddenstatus>UNKNOWN</overriddenstatus>
        <port enabled="true">8888</port>
        <securePort enabled="false">443</securePort>
        <countryId>1</countryId>
        <dataCenterInfo class="com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo">
            <name>MyOwn</name>
        </dataCenterInfo>
        <leaseInfo>
            <renewalIntervalInSecs>30</renewalIntervalInSecs>
            <durationInSecs>90</durationInSecs>
            <registrationTimestamp>1605022781675</registrationTimestamp>
            <lastRenewalTimestamp>1605023772048</lastRenewalTimestamp>
            <evictionTimestamp>0</evictionTimestamp>
            <serviceUpTimestamp>1605022781136</serviceUpTimestamp>
        </leaseInfo>
        <metadata>
            <management.port>8888</management.port>
        </metadata>
        <homePageUrl>http://192.168.3.10:8888/</homePageUrl>
        <statusPageUrl>http://192.168.3.10:8888/actuator/info</statusPageUrl>
        <healthCheckUrl>http://192.168.3.10:8888/actuator/health</healthCheckUrl>
        <vipAddress>eureka-client</vipAddress>
        <secureVipAddress>eureka-client</secureVipAddress>
        <isCoordinatingDiscoveryServer>false</isCoordinatingDiscoveryServer>
        <lastUpdatedTimestamp>1605022781675</lastUpdatedTimestamp>
        <lastDirtyTimestamp>1605022781120</lastDirtyTimestamp>
        <actionType>ADDED</actionType>
    </instance>
    
## 拉获取服务实例列表
    http://localhost:8762/eureka/apps/EUREKA-CLIENT232
 