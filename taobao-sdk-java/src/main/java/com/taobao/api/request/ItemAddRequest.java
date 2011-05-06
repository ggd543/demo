package com.taobao.api.request;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.item.add request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ItemAddRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 商品上传后的状态。可选值:onsale(出售中),instock(仓库中);默认值:onsale
	 **/
	private String approveStatus;
	
	/** 
	 * 商品的积分返点比例。如:5,表示:返点比例0.5%. 注意：返点比例必须是>0的整数，而且最大是90,即为9%.B商家在发布非虚拟商品时，返点必须是 5的倍数，即0.5%的倍数。其它是1的倍数，即0.1%的倍数
	 **/
	private Long auctionPoint;
	
	/** 
	 * 代充商品类型。在代充商品的类目下，不传表示不标记商品类型（交易搜索中就不能通过标记搜到相关的交易了）。可选类型： 
no_mark(不做类型标记) 
time_card(点卡软件代充) 
fee_card(话费软件代充)
	 **/
	private String autoFill;
	
	/** 
	 * 叶子类目id
	 **/
	private Long cid;
	
	/** 
	 * 宝贝描述。字数要大于5个字符，小于25000个字符，受违禁词控制
	 **/
	private String desc;
	
	/** 
	 * ems费用。取值范围:0-100000000;精确到2位小数;单位:元。如:25.07，表示:25元7分
	 **/
	private String emsFee;
	
	/** 
	 * 快递费用。取值范围:0.01-10000.00;精确到2位小数;单位:元。如:15.07，表示:15元7分
	 **/
	private String expressFee;
	
	/** 
	 * 运费承担方式。可选值:seller（卖家承担）,buyer(买家承担);默认值:seller。卖家承担不用设置邮费和postage_id.买家承担的时候，必填邮费和postage_id 
如果用户设置了运费模板会优先使用运费模板，否则要同步设置邮费（post_fee,express_fee,ems_fee）
	 **/
	private String freightPayer;
	
	/** 
	 * 支持会员打折。可选值:true,false;默认值:false(不打折)
	 **/
	private Boolean hasDiscount;
	
	/** 
	 * 是否有发票。可选值:true,false (商城卖家此字段必须为true);默认值:false(无发票)
	 **/
	private Boolean hasInvoice;
	
	/** 
	 * 橱窗推荐。可选值:true,false;默认值:false(不推荐)
	 **/
	private Boolean hasShowcase;
	
	/** 
	 * 是否有保修。可选值:true,false;默认值:false(不保修)
	 **/
	private Boolean hasWarranty;
	
	/** 
	 * 商品主图片。类型:JPG,GIF;最大长度:500K
	 **/
	private FileItem image;
	
	/** 
	 * 加价幅度。如果为0，代表系统代理幅度
	 **/
	private String increment;
	
	/** 
	 * 用户自行输入的类目属性ID串。结构："pid1,pid2,pid3"，如："20000"（表示品牌） 注：通常一个类目下用户可输入的关键属性不超过1个。
	 **/
	private String inputPids;
	
	/** 
	 * 用户自行输入的子属性名和属性值，结构:"父属性值;一级子属性名;一级子属性值;二级子属性名;自定义输入值,....",如：“耐克;耐克系列;科比系列;科比系列;2K5,Nike乔丹鞋;乔丹系列;乔丹鞋系列;乔丹鞋系列;json5”，多个自定义属性用','分割，input_str需要与input_pids一一对应，注：通常一个类目下用户可输入的关键属性不超过1个。所有属性别名加起来不能超过3999字节
	 **/
	private String inputStr;
	
	/** 
	 * 是否是3D
	 **/
	private Boolean is3D;
	
	/** 
	 * 是否在外店显示
	 **/
	private Boolean isEx;
	
	/** 
	 * 是否在淘宝上显示
	 **/
	private Boolean isTaobao;
	
	/** 
	 * 商品文字的字符集。繁体传入"zh_HK"，简体传入"zh_CN"，不传默认为简体
	 **/
	private String lang;
	
	/** 
	 * 定时上架时间。(时间格式：yyyy-MM-dd HH:mm:ss)
	 **/
	private Date listTime;
	
	/** 
	 * 所在地城市。如杭州 。可以通过http://dl.open.taobao.com/sdk/商品城市列表.rar查询
	 **/
	private String locationCity;
	
	/** 
	 * 所在地省份。如浙江，具体可以下载http://dl.open.taobao.com/sdk/商品城市列表.rar  取到
	 **/
	private String locationState;
	
	/** 
	 * 商品数量，取值范围:大于零的整数。数量需要等于Sku所有数量的和
	 **/
	private Long num;
	
	/** 
	 * 商家编码，该字段的最大长度是512个字节
	 **/
	private String outerId;
	
	/** 
	 * 商品主图需要关联的图片空间的相对url。这个url所对应的图片必须要属于当前用户。pic_url和image只需要传入一个,如果两个都传，默认选择pic_url
	 **/
	private String picPath;
	
	/** 
	 * 平邮费用。取值范围:0.01-10000.00;精确到2位小数;单位:元。如:5.07，表示:5元7分. 注:post_fee,express_fee,ems_fee需要一起填写
	 **/
	private String postFee;
	
	/** 
	 * 宝贝所属的运费模板ID。模板可以通过taobao.postages.get获得
	 **/
	private Long postageId;
	
	/** 
	 * 商品价格。取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分。需要在正确的价格区间内。
	 **/
	private String price;
	
	/** 
	 * 商品所属的产品ID(B商家发布商品需要用)
	 **/
	private Long productId;
	
	/** 
	 * 属性值别名。如pid:vid:别名;pid1:vid1:别名1 ，其中：pid是属性id vid是属性值id。总长度不超过511字节
	 **/
	private String propertyAlias;
	
	/** 
	 * 商品属性列表。格式:pid:vid;pid:vid。属性的pid调用taobao.itemprops.get取得，属性值的vid用taobao.itempropvalues.get取得vid。 如果该类目下面没有属性，可以不用填写。如果有属性，必选属性必填，其他非必选属性可以选择不填写.属性不能超过35对。所有属性加起来包括分割符不能超过549字节，单个属性没有限制。 如果有属性是可输入的话，则用字段input_str填入属性的值
	 **/
	private String props;
	
	/** 
	 * 商品所属的店铺类目列表。按逗号分隔。结构:",cid1,cid2,...,"，如果店铺类目存在二级类目，必须传入子类目cids。
	 **/
	private String sellerCids;
	
	/** 
	 * Sku的外部id串，结构如：1234,1342,… 
sku_properties, sku_quantities, sku_prices, sku_outer_ids在输入数据时要一一对应，如果没有sku_outer_ids也要写上这个参数，入参是","(这个是两个sku的示列，逗号数应该是sku个数减1)；该参数最大长度是512个字节
	 **/
	private String skuOuterIds;
	
	/** 
	 * Sku的价格串，结构如：10.00,5.00,… 精确到2位小数;单位:元。如:200.07，表示:200元7分
	 **/
	private String skuPrices;
	
	/** 
	 * 更新的Sku的属性串，调用taobao.itemprops.get获取类目属性，如果属性是销售属性，再用taobao.itempropvalues.get取得vid。格式:pid:vid;pid:vid。该字段内的销售属性也需要在props字段填写。sku的销售属性需要一同选取，如:颜色，尺寸。如果新增商品包含了sku，则此字段一定要传入。这个字段的长度要控制在512个字节以内
	 **/
	private String skuProperties;
	
	/** 
	 * Sku的数量串，结构如：num1,num2,num3 如：2,3
	 **/
	private String skuQuantities;
	
	/** 
	 * 新旧程度。可选值：new(新)，second(二手)，unused(闲置)。B商家不能发布二手商品。
如果是二手商品，特定类目下属性里面必填新旧成色属性
	 **/
	private String stuffStatus;
	
	/** 
	 * 宝贝标题。不能超过60字节，受违禁词控制
	 **/
	private String title;
	
	/** 
	 * 发布类型。可选值:fixed(一口价),auction(拍卖)。B商家不能发布拍卖商品，而且拍卖商品是没有SKU的
	 **/
	private String type;
	
	/** 
	 * 有效期。可选值:7,14;单位:天;默认值:14
	 **/
	private Long validThru;

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	 public String getApproveStatus() {
		return this.approveStatus;
	}
	public void setAuctionPoint(Long auctionPoint) {
		this.auctionPoint = auctionPoint;
	}
	 public Long getAuctionPoint() {
		return this.auctionPoint;
	}
	public void setAutoFill(String autoFill) {
		this.autoFill = autoFill;
	}
	 public String getAutoFill() {
		return this.autoFill;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	 public String getDesc() {
		return this.desc;
	}
	public void setEmsFee(String emsFee) {
		this.emsFee = emsFee;
	}
	 public String getEmsFee() {
		return this.emsFee;
	}
	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}
	 public String getExpressFee() {
		return this.expressFee;
	}
	public void setFreightPayer(String freightPayer) {
		this.freightPayer = freightPayer;
	}
	 public String getFreightPayer() {
		return this.freightPayer;
	}
	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	 public Boolean getHasDiscount() {
		return this.hasDiscount;
	}
	public void setHasInvoice(Boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}
	 public Boolean getHasInvoice() {
		return this.hasInvoice;
	}
	public void setHasShowcase(Boolean hasShowcase) {
		this.hasShowcase = hasShowcase;
	}
	 public Boolean getHasShowcase() {
		return this.hasShowcase;
	}
	public void setHasWarranty(Boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}
	 public Boolean getHasWarranty() {
		return this.hasWarranty;
	}
	public void setImage(FileItem image) {
		this.image = image;
	}
	 public FileItem getImage() {
		return this.image;
	}
	public void setIncrement(String increment) {
		this.increment = increment;
	}
	 public String getIncrement() {
		return this.increment;
	}
	public void setInputPids(String inputPids) {
		this.inputPids = inputPids;
	}
	 public String getInputPids() {
		return this.inputPids;
	}
	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}
	 public String getInputStr() {
		return this.inputStr;
	}
	public void setIs3D(Boolean is3D) {
		this.is3D = is3D;
	}
	 public Boolean getIs3D() {
		return this.is3D;
	}
	public void setIsEx(Boolean isEx) {
		this.isEx = isEx;
	}
	 public Boolean getIsEx() {
		return this.isEx;
	}
	public void setIsTaobao(Boolean isTaobao) {
		this.isTaobao = isTaobao;
	}
	 public Boolean getIsTaobao() {
		return this.isTaobao;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	 public String getLang() {
		return this.lang;
	}
	public void setListTime(Date listTime) {
		this.listTime = listTime;
	}
	 public Date getListTime() {
		return this.listTime;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	 public String getLocationCity() {
		return this.locationCity;
	}
	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}
	 public String getLocationState() {
		return this.locationState;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	 public Long getNum() {
		return this.num;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	 public String getPicPath() {
		return this.picPath;
	}
	public void setPostFee(String postFee) {
		this.postFee = postFee;
	}
	 public String getPostFee() {
		return this.postFee;
	}
	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}
	 public Long getPostageId() {
		return this.postageId;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	 public String getPrice() {
		return this.price;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	 public Long getProductId() {
		return this.productId;
	}
	public void setPropertyAlias(String propertyAlias) {
		this.propertyAlias = propertyAlias;
	}
	 public String getPropertyAlias() {
		return this.propertyAlias;
	}
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}
	public void setSellerCids(String sellerCids) {
		this.sellerCids = sellerCids;
	}
	 public String getSellerCids() {
		return this.sellerCids;
	}
	public void setSkuOuterIds(String skuOuterIds) {
		this.skuOuterIds = skuOuterIds;
	}
	 public String getSkuOuterIds() {
		return this.skuOuterIds;
	}
	public void setSkuPrices(String skuPrices) {
		this.skuPrices = skuPrices;
	}
	 public String getSkuPrices() {
		return this.skuPrices;
	}
	public void setSkuProperties(String skuProperties) {
		this.skuProperties = skuProperties;
	}
	 public String getSkuProperties() {
		return this.skuProperties;
	}
	public void setSkuQuantities(String skuQuantities) {
		this.skuQuantities = skuQuantities;
	}
	 public String getSkuQuantities() {
		return this.skuQuantities;
	}
	public void setStuffStatus(String stuffStatus) {
		this.stuffStatus = stuffStatus;
	}
	 public String getStuffStatus() {
		return this.stuffStatus;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	 public String getTitle() {
		return this.title;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	public void setValidThru(Long validThru) {
		this.validThru = validThru;
	}
	 public Long getValidThru() {
		return this.validThru;
	}

	public String getApiMethodName() {
		return "taobao.item.add";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("approve_status", this.approveStatus);
		textParams.put("auction_point", this.auctionPoint);
		textParams.put("auto_fill", this.autoFill);
		textParams.put("cid", this.cid);
		textParams.put("desc", this.desc);
		textParams.put("ems_fee", this.emsFee);
		textParams.put("express_fee", this.expressFee);
		textParams.put("freight_payer", this.freightPayer);
		textParams.put("has_discount", this.hasDiscount);
		textParams.put("has_invoice", this.hasInvoice);
		textParams.put("has_showcase", this.hasShowcase);
		textParams.put("has_warranty", this.hasWarranty);
		textParams.put("increment", this.increment);
		textParams.put("input_pids", this.inputPids);
		textParams.put("input_str", this.inputStr);
		textParams.put("is_3D", this.is3D);
		textParams.put("is_ex", this.isEx);
		textParams.put("is_taobao", this.isTaobao);
		textParams.put("lang", this.lang);
		textParams.put("list_time", this.listTime);
		textParams.put("location.city", this.locationCity);
		textParams.put("location.state", this.locationState);
		textParams.put("num", this.num);
		textParams.put("outer_id", this.outerId);
		textParams.put("pic_path", this.picPath);
		textParams.put("post_fee", this.postFee);
		textParams.put("postage_id", this.postageId);
		textParams.put("price", this.price);
		textParams.put("product_id", this.productId);
		textParams.put("property_alias", this.propertyAlias);
		textParams.put("props", this.props);
		textParams.put("seller_cids", this.sellerCids);
		textParams.put("sku_outer_ids", this.skuOuterIds);
		textParams.put("sku_prices", this.skuPrices);
		textParams.put("sku_properties", this.skuProperties);
		textParams.put("sku_quantities", this.skuQuantities);
		textParams.put("stuff_status", this.stuffStatus);
		textParams.put("title", this.title);
		textParams.put("type", this.type);
		textParams.put("valid_thru", this.validThru);
		return textParams;
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("image", this.image);
		return params;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
