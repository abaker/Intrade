package org.intrade.data

import xml.Node
import org.intrade.Implicits._

object Response {
  def node2EventClassResponse(req: String, node: Node) = new Response[EventClass] {
    val timestamp: Option[Long] = node.attribute("intrade.timestamp")
    val request: String = req
    val response: Node = node
    val values: Seq[EventClass] = node \ "EventClass" map EventClass.apply
  }

  def node2ContractInformationResponse(req: String, node: Node) = new Response[ContractInformation] {
    val timestamp: Option[Long] = Option.empty
    val request: String = req
    val response: Node = node
    val values: Seq[ContractInformation] = node \ "contract" map ContractInformation.apply
  }

  def node2PriceInformationResponse(req: String, node: Node) = new Response[PriceInformation] {
    val timestamp: Option[Long] = node.attribute("lastUpdateTime")
    val request: String = req
    val response: Node = node
    val values: Seq[PriceInformation] = node \ "contractInfo" map PriceInformation.apply
  }
}

trait Response[A] {
  def timestamp: Option[Long]

  def request: String

  def response: Node

  def values: Seq[A]
}