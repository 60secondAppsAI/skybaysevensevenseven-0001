<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <employee-table
            v-if="employees && employees.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:employees="employees"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-employees="getAllEmployees"
             >

            </employee-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import EmployeeTable from "@/components/EmployeeTable";
import EmployeeService from "../services/EmployeeService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    EmployeeTable,
  },
  data() {
    return {
      employees: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllEmployees(sortBy='employeeId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await EmployeeService.getAllEmployees(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.employees.length) {
					this.employees = response.data.employees;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching employees:", error);
        }
        
      } catch (error) {
        console.error("Error fetching employee details:", error);
      }
    },
  },
  mounted() {
    this.getAllEmployees();
  },
  created() {
    this.$root.$on('searchQueryForEmployeesChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllEmployees();
    })
  }
};
</script>
<style></style>
