package com.ggd543.memcached

import com.danga.MemCached.{MemCachedClient, SockIOPool}


/**
 *
 * User: 刘永健
 * Date: 12-3-10
 * Time: 上午8:21
 * To change this template use File | Settings | File Templates.
 */

object MemcachedClientDemo extends App {

  import scala.collection.JavaConversions._

  def init() = {
    val serverList = Array("192.168.195.128:11211")
    val pool = SockIOPool.getInstance()
    pool.setServers(serverList)
    pool.initialize()
  }

  init()
  test1()

  def test1() {
    val mc = new MemCachedClient()
    // store an object
    val key = "name"
    val value = "Archer"
    mc.set(key, value)
    // retrieve an object from the cache
    val obj = mc.get(key)
    println("an object with " + key + " : " + obj)
    // delete an object
    mc.delete(key)
    println(mc.get(key))
    // retrieve an multiple objects from the cache
    mc.set("key1", "1")
    mc.set("key2", "2")
    mc.set("key3", "3")
    val map = mc.getMulti(Array("key1", "key2", "key3"))
    for ((key, value) <- map) {
      println("key: " + key + " value: " + value)
    }
  }
}
