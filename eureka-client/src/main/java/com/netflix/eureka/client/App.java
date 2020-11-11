package com.netflix.eureka.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * {
 *     "application":{
 *         "name":"EUREKA-CLIENT2",
 *         "instance":[
 *             {
 *                 "instanceId":"eureka-client2:ff5c88562461beed17d209af8dbd2bbc",
 *                 "hostName":"192.168.56.1",
 *                 "app":"EUREKA-CLIENT2",
 *                 "ipAddr":"192.168.56.1",
 *                 "status":"UP",
 *                 "overriddenStatus":"UNKNOWN",
 *                 "port":{
 *                     "$":7777,
 *                     "@enabled":"true"
 *                 },
 *                 "securePort":{
 *                     "$":443,
 *                     "@enabled":"false"
 *                 },
 *                 "countryId":1,
 *                 "dataCenterInfo":{
 *                     "@class":"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
 *                     "name":"MyOwn"
 *                 },
 *                 "leaseInfo":{
 *                     "renewalIntervalInSecs":30,
 *                     "durationInSecs":90,
 *                     "registrationTimestamp":1605081834302,
 *                     "lastRenewalTimestamp":1605086194732,
 *                     "evictionTimestamp":0,
 *                     "serviceUpTimestamp":1605081833795
 *                 },
 *                 "metadata":{
 *                     "management.port":"7777"
 *                 },
 *                 "homePageUrl":"http://192.168.56.1:7777/",
 *                 "statusPageUrl":"http://192.168.56.1:7777/actuator/info",
 *                 "healthCheckUrl":"http://192.168.56.1:7777/actuator/health",
 *                 "vipAddress":"eureka-client2",
 *                 "secureVipAddress":"eureka-client2",
 *                 "isCoordinatingDiscoveryServer":"false",
 *                 "lastUpdatedTimestamp":"1605081834302",
 *                 "lastDirtyTimestamp":"1605081833750",
 *                 "actionType":"ADDED"
 *             },
 *             {
 *                 "instanceId":"eureka-client2:864253c102791a34365b9511d7e6efc3",
 *                 "hostName":"192.168.56.1",
 *                 "app":"EUREKA-CLIENT2",
 *                 "ipAddr":"192.168.56.1",
 *                 "status":"UP",
 *                 "overriddenStatus":"UNKNOWN",
 *                 "port":{
 *                     "$":6666,
 *                     "@enabled":"true"
 *                 },
 *                 "securePort":{
 *                     "$":443,
 *                     "@enabled":"false"
 *                 },
 *                 "countryId":1,
 *                 "dataCenterInfo":{
 *                     "@class":"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
 *                     "name":"MyOwn"
 *                 },
 *                 "leaseInfo":{
 *                     "renewalIntervalInSecs":30,
 *                     "durationInSecs":90,
 *                     "registrationTimestamp":1605086088723,
 *                     "lastRenewalTimestamp":1605086088723,
 *                     "evictionTimestamp":0,
 *                     "serviceUpTimestamp":1605086088208
 *                 },
 *                 "metadata":{
 *                     "management.port":"6666"
 *                 },
 *                 "homePageUrl":"http://192.168.56.1:6666/",
 *                 "statusPageUrl":"http://192.168.56.1:6666/actuator/info",
 *                 "healthCheckUrl":"http://192.168.56.1:6666/actuator/health",
 *                 "vipAddress":"eureka-client2",
 *                 "secureVipAddress":"eureka-client2",
 *                 "isCoordinatingDiscoveryServer":"false",
 *                 "lastUpdatedTimestamp":"1605086088723",
 *                 "lastDirtyTimestamp":"1605086088200",
 *                 "actionType":"ADDED"
 *             }
 *         ]
 *     }
 * }
 */

public class App {

    private Application application;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    static class Application{
        private String name;
        private List<Instance> instance;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Instance> getInstance() {
            return instance;
        }

        public void setInstance(List<Instance> instance) {
            this.instance = instance;
        }
    }

    static class Instance{
        private String instanceId;
        private String hostName;
        private String app;
        private String ipAddr;
//        private Port port;

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getIpAddr() {
            return ipAddr;
        }

        public void setIpAddr(String ipAddr) {
            this.ipAddr = ipAddr;
        }

//        public Port getPort() {
//            return port;
//        }
//
//        public void setPort(Port port) {
//            this.port = port;
//        }
    }

    static class Port{

        private String $;

        public String get$() {
            return $;
        }

        public void set$(String $) {
            this.$ = $;
        }
    }
}
