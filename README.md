# MybatisPlus笔记

### 分表：
#### 垂直分表
#### 水平分表
1. 范围分表
2. 取模分表
---
### 雪花算法
长度64bit
1. 第1位 符号位【1bit】
2. 第2位到第42位 时间戳【41bit】
3. 第43位到52位  工作进程【10bit】
4. 第53位到64位  毫秒内流水号【12bit】（每个节点在每毫秒内可产生4096个ID）
