Tmux避坑指南：
之前只用过screen，退出窗口只需要Ctrl➕a➕d，这次看到说tmux更好用，有超多的快捷键，于是就尝试了一下，没想到创建好一个窗口之后始终没办法退出，怎么按快捷键的前缀Ctrl➕b都没用，后来在网上搜索了一番，总算知道怎么用了。原来它和screen的快捷用法不太一样，不可以一起按着，而是要先按下前缀Ctrl➕b松开后，再按下其他的键下达快捷命令。

Tmux常用指令
1.新建会话

$ tmux new -s <session-name>
2.分离会话

$ Ctrl➕b→d
# 或者输入
$ tmux detach
# 不过一般后台都在运行，直接用快捷键方便
3.查看后台会话

$ tmux ls
# 或者
$ tmux list-session
4.接入会话

# 使用会话编号
$ tmux attach -t 0

# 使用会话名称
$ tmux attach -t <session-name>
5.杀死会话

# 使用会话编号
$ tmux kill-session -t 0

# 使用会话名称
$ tmux kill-session -t <session-name>
6.切换会话

# 使用会话编号
$ tmux switch -t 0

# 使用会话名称
$ tmux switch -t <session-name>
7.重命名会话

$ tmux rename-session -t 0 <new-name>
8.会话快捷键

Ctrl➕b→d：分离当前会话。
Ctrl➕b→s：列出所有会话。
Ctrl➕b→$：重命名当前会话。
9.划分窗格

# 划分上下两个窗格
$ tmux split-window

# 划分左右两个窗格
$ tmux split-window -h
10.移动光标

# 光标切换到上方窗格
$ tmux select-pane -U

# 光标切换到下方窗格
$ tmux select-pane -D

# 光标切换到左边窗格
$ tmux select-pane -L

# 光标切换到右边窗格
$ tmux select-pane -R
11.交换窗格位置

# 当前窗格上移
$ tmux swap-pane -U

# 当前窗格下移
$ tmux swap-pane -D
12.窗格快捷键

Ctrl➕b %：划分左右两个窗格。
Ctrl➕b "：划分上下两个窗格。
Ctrl➕b <arrow key>：光标切换到其他窗格。<arrow key>是指向要切换到的窗格的方向键，比如切换到下方窗格，就按方向键↓。
Ctrl➕b ;：光标切换到上一个窗格。
Ctrl➕b o：光标切换到下一个窗格。
Ctrl➕b {：当前窗格左移。
Ctrl➕b }：当前窗格右移。
Ctrl➕b Ctrl➕o：当前窗格上移。
Ctrl➕b Alt➕o：当前窗格下移。
Ctrl➕b x：关闭当前窗格。
Ctrl➕b !：将当前窗格拆分为一个独立窗口。
Ctrl➕b z：当前窗格全屏显示，再使用一次会变回原来大小。
Ctrl➕b Ctrl➕<arrow key>：按箭头方向调整窗格大小。
Ctrl➕b q：显示窗格编号。

13.Configuration

# set base index to 1 for windows
set -g base-index 1

# rebind prefix to ctrl+a
unbind C-b
set -g prefix C-a
bind C-a send-prefix

# Switch panes using alt+arrow keys
bind -n M-Left select-pane -L
bind -n M-Right select-pane -R
bind -n M-UP select-pane -U
bind -n M-Down select-pane -D

# Allow mouse control
set -g mouse on

# Turn off audio bell
set -g bell-action none

# turn visual bell on
set -g visual-bell on

# when I had Tmux wrap any shell I used, this command was useful to attatch
# Tmux to my current directory
# Binds to prefix + p
bind p attach -c "#{pane_current_path}"


Screen常用指令
1.语法

# screen [-AmRvx -ls -wipe][-d <作业名称>][-h <行数>][-r <作业名称>][-s ][-S <作业名称>]

参数说明

-A 　将所有的视窗都调整为目前终端机的大小。
-d <作业名称> 　将指定的screen作业离线。
-h <行数> 　指定视窗的缓冲区行数。
-m 　即使目前已在作业中的screen作业，仍强制建立新的screen作业。
-r <作业名称> 　恢复离线的screen作业。
-R 　先试图恢复离线的作业。若找不到离线的作业，即建立新的screen作业。
-s 　指定建立新视窗时，所要执行的shell。
-S <作业名称> 　指定screen作业的名称。
-v 　显示版本信息。
-x 　恢复之前离线的screen作业。
-ls或--list 　显示目前所有的screen作业。
-wipe 　检查目前所有的screen作业，并删除已经无法使用的screen作业。
2.常用screen参数

 screen -S yourname -> 新建一个叫yourname的session
screen -ls -> 列出当前所有的session
screen -r yourname -> 回到yourname这个session
screen -d yourname -> 远程detach某个session
screen -d -r yourname -> 结束当前session并回到yourname这个session
3.快捷指令

在每个screen session 下，所有命令都以Ctrl➕a开始。
Ctrl➕a ? -> 显示所有键绑定信息
Ctrl➕a c -> 创建一个新的运行shell的窗口并切换到该窗口
Ctrl➕a n -> Next，切换到下一个 window 
Ctrl➕a p -> Previous，切换到前一个 window 
Ctrl➕a 0..9 -> 切换到第 0..9 个 window
Ctrl+a [Space] -> 由视窗0循序切换到视窗9
Ctrl➕a Ctrl➕a -> 在两个最近使用的 window 间切换 
Ctrl➕a x -> 锁住当前的 window，需用用户密码解锁
Ctrl➕a d -> detach，暂时离开当前session，将目前的 screen session (可能含有多个 windows) 丢到后台执行，并会回到还没进 screen 时的状态，此时在 screen session 里，每个 window 内运行的 process (无论是前台/后台)都在继续执行，即使 logout 也不影响。 
Ctrl➕a z -> 把当前session放到后台执行，用 shell 的 fg 命令则可回去。
Ctrl➕a w -> 显示所有窗口列表
Ctrl➕a t -> Time，显示当前时间，和系统的 load 
Ctrl➕a k -> kill window，强行关闭当前的 window
Ctrl➕a [ -> 进入 copy mode，在 copy mode 下可以回滚、搜索、复制就像用使用 vi 一样
    C-b Backward，PageUp 
    C-f Forward，PageDown 
    H(大写) High，将光标移至左上角 
    L Low，将光标移至左下角 
    0 移到行首 
    $ 行末 
    w forward one word，以字为单位往前移 
    b backward one word，以字为单位往后移 
    Space 第一次按为标记区起点，第二次按为终点 
    Esc 结束 copy mode 
Ctrl➕a ] -> Paste，把刚刚在 copy mode 选定的内容贴上