package org.scoula;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.travel.domain.TravelVO;

import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        /*
        CsvToBeanBuilder<T> 클래스
        - csv 파일의 한 라인을 읽어 지정한 T타입의 인스턴스로 변환해주는 클래스
        - csv 파일의 헤더(첫 번째 줄) 명과 같은 T 클래스의 필드로 매핑
         */
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();

        travels.forEach(System.out::println);
    }
}
