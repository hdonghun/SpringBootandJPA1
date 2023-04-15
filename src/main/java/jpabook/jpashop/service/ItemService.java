package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 변경감지 사용
    @Transactional // Transactional에 의해서, 커밋이 된다. 플러쉬를 날린다? 영속성 컨테스트에서 변경된것은 무엇인지 찾는다. 찾은후에 그것을 데이터 업데이트쿼리를 날려서 DB에 업데이트한다.
    // 변경감지에 의해서 데이터 처리하는 방법임.
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId); // 여기서 findItem으로 가져온것은 영속상태이다.
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    // 병합 사용하기
    // 병합은 준영속 상태의 엔티티를 영속 상태로 변경할 떄 사용하는 기능이다.


    public List<Item> findItems(){
        return itemRepository.findAll();
    }
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
