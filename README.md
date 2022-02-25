<div align="center">
    <h1>AES 对称性加密</h1>
    <a href="https://github.com/996icu/996.ICU/blob/master/LICENSE">
        <img alt="License-Anti" src="https://img.shields.io/badge/License-Anti 996-blue.svg">
    </a>
    <a href="https://996.icu/#/zh_CN">
        <img alt="Link-996" src="https://img.shields.io/badge/Link-996.icu-red.svg">
    </a>
</div>

<p align="center">
  为简化开发工作、提高生产率而生
</p>

<p align="center">
  <a href="https://search.maven.org/artifact/cn.com.xuxiaowei.utils/aes">
    <img alt="maven" src="https://img.shields.io/maven-central/v/cn.com.xuxiaowei.utils/aes.svg?style=flat-square">
  </a>

  <a href="https://www.apache.org/licenses/LICENSE-2.0">
    <img alt="code style" src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square">
  </a>
</p>

## 示例

- 代码

```
String content = "Hello World";
String seed = "xuxiaowei.com.cn";

System.out.println("原文：" + content);
System.out.println("种子（密码）：" + seed);

String encryptStr = Aes.encryptStr(content, seed);
System.out.println("加密结果：" + encryptStr);

String decryptStr = Aes.decryptStr(encryptStr, seed);
System.out.println("解密结果：" + decryptStr);
```

- 结果

```
原文：Hello World
种子（密码）：xuxiaowei.com.cn
加密结果：e33b80dab15be20728f0dccaee94d90b
解密结果：Hello World
```

### 其他示例

- String、byte 类型的示例，查看测试类

## JS

- [crypto-js](https://cdnjs.com/libraries/crypto-js)

