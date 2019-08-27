package net.DianC.dp.quartz.task;

import java.util.Arrays;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class InitKafkaListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("init success");
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.61.5.235:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		// KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		KafkaConsumer consumer = new KafkaConsumer(props);
		consumer.subscribe(Arrays.asList("Topic011"));
//		while (true) {
//		    ConsumerRecords<String, String> records = consumer.poll(100);
//		    for (ConsumerRecord<String, String> record : records)
//		        System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
//		}
	}
}
