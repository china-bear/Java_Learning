package fileTest;

public class test01 {

    public static void main(String[] args) {
        String path = "hdfs://namenode.safe.lycc.qihoo.net:9000/home/hdp-ads-dw/hive/warehouse/hdp_ads_dw.db/ods/ods_mediav_base_adspace_pdb_ext/dt=2020-06-17";

        String[] a = path.split("//");
        String rs ;

        if (a == null )
            rs = null;

        int iMax = a.length - 1;
        if (iMax == -1)
            rs = "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                rs= b.append(']').toString();
            b.append(", ");
        }

    }
}
