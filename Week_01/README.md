学习笔记
   
   本周学习了数组、链表、跳表、栈、队列、双端队列、双端队列这些数据结构，他们的特点如下如下：

一、数组
数组，申请时在内存中开辟连续地址，时间复杂度O(1)查询任何下标的元素。
为了维持地址连续的特点，插入和删除元素的时间复杂度较高，会有群移操作，时间复杂度O(n)。

二、链表
链表的内存地址不连续，链表中的每个元素是一个节点，每个节点都有相应的值。链表有两种类型。
节点包含指向下一个节点的指针，以这样的节点组成的链表为单向链表。
节点包含指向上一个节点的指针和指向下一个节点的指针，以这样的节点组成的链表为双向链表。
在链表中插入和删除元素时，只需要改变相邻节点的指针指向的节点，因此时间复杂度都是O(1)。
链表的内存地址不连续，查询需要遍历节点才能查询元素，因此查询的时间复杂度是O(n)。

三、跳表
跳表的实现基于链表，其目的是降低链表的查询元素的时间复杂度。只适用于元素有序的情况。
跳表对标平衡二叉搜索树和二分查找，插入、删除、查询元素的时间复杂度都是O(log n)。
跳表通过升维的方式进行加速，从一维到二维，包含更多信息。具体实现为在原始链表的基础上增加多级索引，每级索引包含的节点数量依次减少。
跳表的空间复杂度和数组、链表一样是O(n)，但是由于跳表有多级索引，实际使用空间超过数组和链表。

四、栈
Stack：后进先出，添加、删除元素的时间复杂度是O(1)。
元素无序，查询的时间复杂度是O(n)。

五、队列
Queue：先进先出，添加、删除元素的时间复杂度是O(1)。
元素无序，查询的时间复杂度是O(n)。

六、双端队列
Deque即Double-Ended Queue：结合了栈和队列的特点，可在头和尾两端添加和删除元素。
双端队列的各项操作的时间复杂度和栈与队列相同，添加、删除元素的时间复杂度是O(1)，查询的时间复杂度是O(n)。

七、优先队列
Priority Queue：元素具有优先级顺序，每次取出优先级最高的元素（例如最大值或最小值）。
添加元素的时间复杂度是O(1)，取出元素的时间复杂度是O(log n)。

作业
一、改写Deque
原始代码：

Deque<String> deque = new LinkedList<String>();

deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.pop());
}
System.out.println(deque);

改写后：

Deque<String> deque = new LinkedList<String>();

deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);

二、分析Queue和Priority Queue的源码
Queue的源码分析
Queue是一个接口，继承了Collection接口。Queue接口只包含抽象方法。
Queue接口包含以下抽象方法。
boolean add(E e)：
往队列尾部添加元素，如果添加成功则返回true，如果因为容量限制导致添加失败则抛出IllegalStateException异常。
boolean offer(E e)：
往队列尾部添加元素，如果添加成功则返回true，如果因为容量限制导致添加失败则返回false。可见在有容量限制的队列中，offer方法由于add方法。
E remove()：
删除队列头部的元素并返回，如果队列为空则抛出NoSuchElementException。
E poll()：
删除队列头部的元素并返回，如果队列为空则返回null。
E element()：
返回队列头部的元素（不从队列删除元素），如果队列为空则抛出NoSuchElementException。
E peek()：
返回队列头部的元素（不从队列删除元素），如果队列为空则返回null。

PriorityQueue的源码分析
PriorityQueue是一个具体类，其底层实现为数组。该类包含的方法较多，此处只分析常用的方法。
添加元素，boolean add(E e)和boolean offer(E e)，当参数e为空时抛出NullPointerException异常，否则执行添加元素，首先判断是否需要扩容，以及在需要扩容的情况下进行扩容，然后将e加到数组末尾，最后对e进行上浮操作以保持优先队列的性质（例如当头部元素最小时，每个元素都比其子节点小）。
查看头部元素，E peek()，如果优先队列为空则返回null，否则返回数组的第一个元素。
移除头部元素并返回，E poll()，如果优先队列为空则返回null，否则将数组的第一个元素作为返回值，将数组的最后一个元素移到数组的第一个元素（原来的最后一个元素变成null），对数组的第一个元素进行下沉操作以保持优先队列的性质（例如当头部元素最小时，每个元素都比其子节点小），最后返回移除的元素。