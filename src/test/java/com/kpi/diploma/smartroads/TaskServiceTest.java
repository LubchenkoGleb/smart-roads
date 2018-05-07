package com.kpi.diploma.smartroads;


import com.kpi.diploma.smartroads.model.dto.task.KMeansRow;
import com.kpi.diploma.smartroads.service.primary.TaskService;
import com.kpi.diploma.smartroads.service.primary.impl.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TaskServiceTest {


//    private TaskService taskService;

//    @Mock
//    private ContainerRepository containerRepository;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        this.taskService = new TaskServiceImpl(companyRepository, userRepository, containerRepository);
//
//    }
//
//    @Test
//    public void testCreateTaskService() {
//
//        int containersAmount = 3;
//
//        List<Container> containers = new ArrayList<>();
//
//        for (int i = 0; i < containersAmount; i++) {
//
//            List<MapObjectDetail> mapObjectDetails = new ArrayList<>();
//            for (int j = 0; j < 3; j++) {
//                MapObjectDetail mapObjectDetail = new MapObjectDetail();
//                mapObjectDetail.setType(ContainerValues.values()[j]);
//                mapObjectDetail.setAmount(j + 1);
//                mapObjectDetail.setFull(true);
//                mapObjectDetails.add(mapObjectDetail);
//            }
//
//            Container container = new Container();
//            container.setDetails(mapObjectDetails);
//            container.setId("id_" + i);
//
//
//            List<Route> startRoutes = new ArrayList<>();
//            for (int j = 0; j < containersAmount; j++) {
//                if(i != j) {
//                    startRoutes.add(new Route(new MapObject(container.getId()), new MapObject("id_" + j), i * j + 1L, null));
//                }
//            }
//            container.setStartRoutes(startRoutes);
//
//            containers.add(container);
//        }
//        log.info("'containers={}'", containers);
//
//        when(containerRepository.findAllByOwnerId(any())).thenReturn(containers);
//
//        taskService.createTaskForService("1");
//
//    }


    @Test
    public void tess_normalizeKMeans() {

//        TaskService taskService = new TaskServiceImpl(null, null, mapObjectRepository);

        List<List<String>> clustersByIds = Arrays.asList(
                Arrays.asList("id0"),
                Arrays.asList("id1", "id2", "id3", "id4", "id5"),
                Arrays.asList("id7", "id8", "id9", "id10"),
                Arrays.asList("id6"));

        List<KMeansRow> matrix = Arrays.asList(
                new KMeansRow("id0",  Arrays.asList(0L,  4L,  6L,  6L,  6L,  6L,  13L, 15L, 11L, 13L, 15L)),
                new KMeansRow("id1",  Arrays.asList(4L,  0L,  2L,  2L,  2L,  2L,  10L, 12L, 8L,  10L, 12L)),
                new KMeansRow("id2",  Arrays.asList(6L,  2L,  0L,  2L,  4L,  2L,  8L,  10L, 6L,  8L,  10L)),
                new KMeansRow("id3",  Arrays.asList(6L,  2L,  2L,  0L,  2L,  0L,  7L,  9L,  5L,  7L,  9L)),
                new KMeansRow("id4",  Arrays.asList(6L,  2L,  4L,  2L,  0L,  2L,  7L,  9L,  5L,  7L,  9L)),
                new KMeansRow("id5",  Arrays.asList(6L,  2L,  2L,  0L,  2L,  0L,  7L,  9L,  5L,  7L,  9L)),
                new KMeansRow("id6",  Arrays.asList(13L, 10L, 8L,  7L,  7L,  7L,  0L,  2L,  4L,  6L,  4L)),
                new KMeansRow("id7",  Arrays.asList(15L, 12L, 10L, 9L,  9L,  9L,  2L,  0L,  2L,  4L,  2L)),
                new KMeansRow("id8",  Arrays.asList(11L, 8L,  6L,  5L,  5L,  5L,  4L,  2L,  0L,  2L,  4L)),
                new KMeansRow("id9",  Arrays.asList(13L, 10L, 8L,  7L,  7L,  7L,  6L,  4L,  2L,  0L,  2L)),
                new KMeansRow("id10", Arrays.asList(15L, 12L, 10L, 9L,  9L,  9L,  4L,  2L,  4L,  2L,  0L)));

//        ((TaskServiceImpl) taskService).normalizeKMeans(3, clustersByIds, matrix);
    }

    @Test
    public void testListRemove() {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 1));
        integers.remove(1);
        log.info("'integers={}'", integers);
    }
}
