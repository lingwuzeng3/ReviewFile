# 移动应用开发实验期末技术报告

## 选题建议  
- 在线音乐播放APP
- 在线预告片播放APP
- 在线天气预报APP
- 在线新冠肺炎疫情播报APP
- 在线电视节目预告APP
- 在线电影播放APP
- 在线新闻APP
- 在线旅游路线规划APP
- 基于互联网的联网游戏APP
- 在线智能聊天APP

## 功能要求

- [ ] 用户的登入和注册
- [ ] 可以自定义用户信息
- [ ] 可以修改App的主题样式
- [ ] 能够访问网络
- [ ] 使用数据库
- [ ] 使用并发处理

## 设计思路


## 遇到的问题


### kotlin generic type
1. generic type in kotlin

The generic of`koltin` is very different from `java`, which mainly reflects on the
usage of `wildcards` .

Java uses `wildcards` a lot. First, Let us go through a example to show the power of `wildcards` in java.

Assume There is a interface for `Collection<E>` 

```java
interface Collection<E> ... {
    void addAll(Collection<E> items);
}
```

And it is impossible if we want to perform the following function

```java
void copyAll(Collection<Object> to, Collection<String> from) {
    to.addAll(from);
    // !!! Would not compile with the naive declaration of addAll:
    // Collection<String> is not a subtype of Collection<Object>
}
```

Because `Collection<Object>` if not the super class of `Collection<String>`. 
This feature indeed provides more safety, but it costs a little flexibility

To handle this, `Java` use the power of `wildcards`. 

```java
interface Collection<E> ... {
    void addAll(Collection<? extends E> items);
}
```

> The wildcard type argument ? extends E indicates that this method accepts a collection of objects of E or a subtype of E, not just E itself.



### wild behavior 
The following code generate stackoverflow error

```kotlin
open class BaseBuildingMaterial (var numberNeeded:Int = 1)

class Wood(): BaseBuildingMaterial() {
    init {
        numberNeeded = 4;
    }
}
class Brick(): BaseBuildingMaterial() {
    init {
        numberNeeded = 8;
    }
}

class Building<T: BaseBuildingMaterial> (var material: T,  var baseMaterialsNeeded:Int = 100) {
    var actualMatrialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded
        set(value) {
            actualMatrialsNeeded = value
        }


    fun build()  {
        println("$actualMatrialsNeeded ${material::class.simpleName} needed")
    }
}
```

### notes on kotlin

we can use async() function to synchronize suspending function, and use await() to get 
results.

or we can use coroutines {} .

