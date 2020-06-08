############################################
1、key过期事件监听
***需要redis.windows.conf文件修改notify-keyspace-events value为 Ex

参数说明：
    K：keyspace事件，事件以__keyspace@<db>__为前缀进行发布；        
    E：keyevent事件，事件以__keyevent@<db>__为前缀进行发布；        
    g：一般性的，非特定类型的命令，比如del，expire，rename等；       
    $：字符串特定命令；        
    l：列表特定命令；        
    s：集合特定命令；        
    h：哈希特定命令；        
    z：有序集合特定命令；        
    x：过期事件，当某个键过期并删除时会产生该事件；        
    e：驱逐事件，当某个键因maxmemore策略而被删除时，产生该事件；        
    A：g$lshzxe的别名，因此”AKE”意味着所有事件。
