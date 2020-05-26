package org.example.common.mq;

/**
 * @author smq
 */

public class Constant {

	public static final String QUEUE_1 = "queue_1";


	public static final String EXCHANGE_1 = "exchange_1";

	public static final String QUEUE_2 = "queue_2";
	public static final String ROUTING_KEY_1 = "topic.message";

	public static final String QUEUE_3 = "queue_3";
	// # 模糊匹配
	public static final String ROUTING_KEY_2 = "topic.#";

	public static final String ROUTING_KEY_3 = "topic.messages";


	public static final String FANOUT_EXCHANGE_1 = "fanout_exchange_1";

	public static final String QUEUE_FANOUT_1 = "queue_fanout_1";
	public static final String QUEUE_FANOUT_2 = "queue_fanout_2";
	public static final String QUEUE_FANOUT_3 = "queue_fanout_3";


}
