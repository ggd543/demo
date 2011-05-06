package app


import java.util.Properties
import javax.persistence.Persistence
import poso.UserEntity

/*******************************************************************************
 * Copyright (c) 2009 Kalengo, LLC. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Kalengo, LLC. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kalengo.
 *
 * KALENGO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. KALENGO SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * CopyrightVersion 1.0
 *
 *
 *
 * $HeadURL$
 * @author $Author $
 * @version $Revision $   $Date $
 * @see
 * @since
 ******************************************************************************/
object JPADemoWithConnectionPool {
//  val prop=new Properties
//  prop.setProperty("datanucleus.connectionPool.minPoolSize", "5")
//  prop.setProperty("datanucleus.connectionPool.initialPoolSize", "5")
//  prop.setProperty("datanucleus.connectionPool.maxPoolSize", "5")
//  val emf = Persistence.createEntityManagerFactory("dbunit", prop)
  val emf = Persistence.createEntityManagerFactory("dbunit")

  def getUserEntity(userId: Long): UserEntity = {
    val em = emf.createEntityManager
    val entity = em.find(classOf[UserEntity], userId)
    em.close
    if (entity == null) null else entity
  }

  def addUserEntity(userEntity: UserEntity): Long = {
    val em = emf.createEntityManager
    val tx = em.getTransaction
    tx.begin
    em.persist(userEntity)
    tx.commit
    em.close
    userEntity.userId.longValue
  }

  def main(args: Array[String]): Unit = {
    val userEntity1 = createDefaultUserEntity
    val userId1 = addUserEntity(userEntity1)
    println(getUserEntity(userId1))

    val userEntity2 = createDefaultUserEntity
    val userId2 = addUserEntity(userEntity2)
    println(getUserEntity(userId2))
    
    Thread.sleep(10000L)
  }

  def createDefaultUserEntity(): UserEntity = {
    val userEntity = new UserEntity
    userEntity.username = "archer"
    userEntity.password = "4phvjs"
    return userEntity;
  }

}