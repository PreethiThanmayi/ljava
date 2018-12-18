package com.cg.flat.dao;

public interface QueryMapper {
	
	public static final String INSERT_QUERY="insert into customer values(cust_seq.nextval,?,?,?,?,?,sysdate,?,null)";
	public static final String UPDATE_QUERY="update flat set flatavty=(select flatavty from flat where cusflatid=?)-1 where cusflatid=?";
	public static final String SELECT_QUERY="select * from flat ";
	public static final String SELECT_QUERY_CUST="select * from customer where cusNum=?";
	public static final String SELECT_QUERY_FLAT="select f.cusflatid,f.flatarea ,f.flattype , f.flatsqft ,f.flatprice ,f.flatavty from flat f,customer c where f.cusflatid=? and c.cusnum=? and f.cusflatid=c.cusflatid";
}