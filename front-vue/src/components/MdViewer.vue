<!--md查看-->
<template>
  <mavon-editor v-model="value" :editable="false" :navigation="false" :subfield="false" :toolbars-flag="false"
                default-open="preview"/>

</template>

<script>
export default {
  name: "MdViewer",
  data() {
    return {
      value: `## JavaIO

## File类

<img src="C:\\Users\\HP\\AppData\\Roaming\\Typora\\typora-user-images\\image-20210425102229160.png" alt="image-20210425102229160" style="zoom:67%;" />

用于描述电脑中的文件(可以是目录)，也可以是不存在的文件，包含了对文件描述信息的读写(如获取文件的长度，是否可读可写可执行等权限信息，文件是否存在，文件的删除、创建，移动，查看文件夹下的所有文件)，**以下文件或文件夹统称文件**

### constructors

1. File(String pathname)
2. File(File parent, String child)
3. File(String parent, String child)

示例：

\`\`\`java
File file = new File("I:\\\\BaiduNetdiskDownload\\\\good.jpg");
\`\`\`

表示获取I:\\BaiduNetdiskDownload\\good.jpg这个文件，如果参数是文件夹，则获取对应文件夹，如果参数的文件(或文件夹)不存在也不会异常，但是无法对不存在的文件进行

### 常用方法

#### 查看相关

\`\`\`java
1. boolean canRead()\t判断这个文件是否可读
2. boolean canWrite()\t是否可写
3. boolean exists() \t文件是否存在
4. long lastModified() \t文件上次修改的时间(返回时间戳)
5. long length() \t\t文件长度(byte为单位)
6. String[] list()\t\t列出this下的所有文件以及文件夹的名字，可能返回null
7. File[] listFiles()\t同6，不过结果是File，返回也可能为null
\`\`\`

#### 新建文件夹

\`\`\`java
1. boolean mkdir() \t\t新建文件夹(只能建一级，如果要建嵌套的文件夹用mkdirs)
2. boolean mkdirs()\t\t递归创建文件夹(可建多级目录)
\`\`\`
#### 新建文件

\`\`\`java
boolean createNewFile()\t\t新建文件,只能针对不存在的File，同时文件的上级目录一定要存在两个都满足才能创建成功;如果存在则啥也没做
\`\`\`

`
    }
  }
}
</script>

<style scoped>

</style>