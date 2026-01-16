# 汇编实验一

- 首先设置磁盘映射
```bash
mount c d:\asm # 将 d:\asm 虚拟为模拟器的c盘
```

- type `debug` to enter debug mode
    - type `r` to display the register value 
    - type `q` to quit
    - type `d` to display the `Data Segment` in memory
    ```bash
    -D (segmentname:DS)[start memory:100] L [Length:128]
    example:
        -D 100 # display 128 bytes in DS start from 0100H
        -D CS:200 # display 128 bytes in CS start from 0200H
        -D CS:200 L 10 # display 10 bytes in CS start from 0200H
        
    ```

    - type `E` (erase) to change the value in the memory
    ```bash
    -E[start memory] (interactive mode)
    example:
        -E100 # 从0100H 开始改变地址单元的值
    -E[start memory] (数据表) 
    example:
        -E100 41 42 43 44 45 46 47 48 # 从0100H 将数据表中的值写入内存  
    ```
    - type `T` to execute command
    ```bash
    -T # 单步执行指令
    -T5 # 执行5条指令
    -T=100 5 # 从给定地址执行5条指令

    ```

    - type `A` to translate assemblely code to machine code and wirte to mem
    ```bash
    -a 100 # type command from address 100
    ```

    - type `G` to execute program

    ```bash
    -G # 执行程序 
    -G=100 # 从指定地址开始执行程序
    -G=100 断点[] # 从给定地址执行5条指令

    ```
| 1000H | 2000H | 结果(1000H) | 进位 |
|-------|-------|-------------|------|
| 01    | FF    | 00          | 1    |
| 02    | FF    | 01 + 1 = 02 | 1    |
| 03    | FF    | 02 + 1 = 03 | 1    |
| 04    | FF    | 04 + 1 = 04 | 1    |
| 01    | FF    | 00 + 1 = 01 | 1    |
| 02    | FF    | 01 + 1 = 02 | 1    |
| 03    | FF    | 02 + 1 = 03 | 1    |
| 04    | FF    | 04 + 1= 04  | 1    |


| 入口参数AH | 功能                   | 输入                                                     | 返回参数             |
|------------|------------------------|----------------------------------------------------------|----------------------|
| 02H        | 打印字符               | DL = 输出字符                                            |                      |
| 09H        | 打印字符串             | DX = 字符串首地址                                        |                      |
| 0AH        | 将用户的输入存入缓冲区 | DS:DX= 缓冲区对应首地址 </br> (DS:DX) = 缓冲区最大字符数 | (DS:DX+1) 实际字符数 |
| 07H        | 键盘输入无回显         |                                                          | AL=输入字符          |
