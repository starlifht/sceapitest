package star.test.methods;

import java.io.IOException; 
import java.util.concurrent.TimeoutException; 
 


import net.rubyeye.xmemcached.MemcachedClient; 
import net.rubyeye.xmemcached.MemcachedClientBuilder; 
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder; 
import net.rubyeye.xmemcached.exception.MemcachedException; 
import net.rubyeye.xmemcached.utils.AddrUtil; 
 
public class testMem { 
 
    /**
     * @param args
     * @throws Exception 
     */ 
    public static void main(String[] args) throws Exception { 
        // TODO Auto-generated method stub 
    //    MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("10.121.35.54:11211"),new int[]{1,3}); 
      
        	 XMemcachedClient client  =   new  XMemcachedClient("10.121.35.54", 11211);
        	 client.set("05d4db5090de3a4676bdd05925c28917",8888,"05dadb2090deca4d76bdd05d25c26917");
        client.set("test", 5555, "sf");
      //    MemcachedClient memcachedClient = builder.build(); 
//            memcachedClient.
//            memcachedClient.set("hello", 1, "Hello,xmemcached"); 
//            String Value=memcachedClient.get("hello",3000); // 
            System.out.println(client.get("test")); 

             
           // memcachedClient.shutdown(); 
     
    } 
 
} 