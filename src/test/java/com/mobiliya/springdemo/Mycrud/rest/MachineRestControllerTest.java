package com.mobiliya.springdemo.Mycrud.rest;

import com.mobiliya.springdemo.Mycrud.entity.Location;
import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.service.MachineService;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MachineRestController.class)
public class MachineRestControllerTest {

    @MockBean
    private MachineService machineService;

    @MockBean
    private MachineRestController machineRestController;

    @Autowired
    private MockMvc mockMvc;

    Location location = new Location(1, "Awalgaon", 458963);
    Machine machine = new Machine(1, "IBM CPLEX", 5, (float) 458.5, 1, location);

    String json_format = "[{\"machine_id\":1,\"name\":\"IBM CPLEX\",\"parts_count\":5,\"price\":458.5,\"location_id\":1,\"location\":{\"location_id\":1,\"city\":\"Awalgaon\",\"area_code\":458963}}]";

    List<Machine> machines = new LinkedList<Machine>();

    @Test
    public void getMachinesAll_basic() throws Exception {

        machines.add(machine);
        when(machineRestController.findAll()).thenReturn(machines);
        System.out.println(machines.get(0));

        RequestBuilder request = MockMvcRequestBuilders.get("/api/machines")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        JSONAssert.assertEquals(json_format, result.getResponse().getContentAsString(), false);
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void getMachinesAll_WhenNull() throws Exception {
        when(machineRestController.findAll()).thenReturn(null);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/machines")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    }

    @Test
    public void getMachineById_basic() throws Exception {


        String json_format = "{\"machine_id\":1,\"name\":\"IBM CPLEX\",\"parts_count\":5,\"price\":458.5,\"location_id\":1,\"location\":{\"location_id\":1,\"city\":\"Awalgaon\",\"area_code\":458963}}";
        when(machineRestController.getMachineById(1)).thenReturn(machine);

        RequestBuilder request = MockMvcRequestBuilders.get("/api/machines/1")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        JSONAssert.assertEquals(json_format, result.getResponse().getContentAsString(), false);
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void DeleteMachine_basic() throws Exception {


        when(machineRestController.DeleteMachine(1)).thenReturn("Deleted Machine with id  : " + 1);

        String expected_response = "Deleted Machine with id  : 1";

        RequestBuilder request = MockMvcRequestBuilders.delete("/api/machines/1")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        Assertions.assertEquals(expected_response, result.getResponse().getContentAsString());
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void DeleteMachine_WhenMachineIdIsNotPresent() throws Exception {


        when(machineRestController.DeleteMachine(0)).thenReturn("Machine does not exist ...");

        String expected_response = "Machine does not exist ...";

        RequestBuilder request = MockMvcRequestBuilders.delete("/api/machines/0")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        Assertions.assertEquals(expected_response, result.getResponse().getContentAsString());
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void AddMachine_Basic() throws Exception {

        String content = "{\"machine_id\":1,\"name\":\"NVIDIA GTX\",\"parts_count\":2,\"price\":145.5,\"location_id\":1}";
        when(machineRestController.AddMachine(machine)).thenReturn(machine);
        RequestBuilder request = MockMvcRequestBuilders.post("/api/machines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
       // JSONAssert.assertEquals(content, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void UpdateMachine_Basic() throws Exception {

        String content = "{\"machine_id\":1,\"name\":\"NVIDIA GTX\",\"parts_count\":2,\"price\":145.5,\"location_id\":1}";
        when(machineRestController.UpdateMachine(machine)).thenReturn(machine);
        RequestBuilder request = MockMvcRequestBuilders.put("/api/machines/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        // JSONAssert.assertEquals(content, result.getResponse().getContentAsString(), false);
    }

}
