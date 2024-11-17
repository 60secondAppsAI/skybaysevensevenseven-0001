import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Flights from  '@/pages/Flights.vue';
import FlightDetail from  '@/pages/FlightDetail.vue';
import Airlines from  '@/pages/Airlines.vue';
import AirlineDetail from  '@/pages/AirlineDetail.vue';
import Aircrafts from  '@/pages/Aircrafts.vue';
import AircraftDetail from  '@/pages/AircraftDetail.vue';
import Passengers from  '@/pages/Passengers.vue';
import PassengerDetail from  '@/pages/PassengerDetail.vue';
import Bookings from  '@/pages/Bookings.vue';
import BookingDetail from  '@/pages/BookingDetail.vue';
import Airports from  '@/pages/Airports.vue';
import AirportDetail from  '@/pages/AirportDetail.vue';
import Tickets from  '@/pages/Tickets.vue';
import TicketDetail from  '@/pages/TicketDetail.vue';
import Crews from  '@/pages/Crews.vue';
import CrewDetail from  '@/pages/CrewDetail.vue';
import CrewAssignments from  '@/pages/CrewAssignments.vue';
import CrewAssignmentDetail from  '@/pages/CrewAssignmentDetail.vue';
import Routes from  '@/pages/Routes.vue';
import RouteDetail from  '@/pages/RouteDetail.vue';
import Baggages from  '@/pages/Baggages.vue';
import BaggageDetail from  '@/pages/BaggageDetail.vue';
import CheckIns from  '@/pages/CheckIns.vue';
import CheckInDetail from  '@/pages/CheckInDetail.vue';
import Gates from  '@/pages/Gates.vue';
import GateDetail from  '@/pages/GateDetail.vue';
import Meals from  '@/pages/Meals.vue';
import MealDetail from  '@/pages/MealDetail.vue';
import LoyaltyPrograms from  '@/pages/LoyaltyPrograms.vue';
import LoyaltyProgramDetail from  '@/pages/LoyaltyProgramDetail.vue';
import Memberships from  '@/pages/Memberships.vue';
import MembershipDetail from  '@/pages/MembershipDetail.vue';
import BoardingPasss from  '@/pages/BoardingPasss.vue';
import BoardingPassDetail from  '@/pages/BoardingPassDetail.vue';
import Feedbacks from  '@/pages/Feedbacks.vue';
import FeedbackDetail from  '@/pages/FeedbackDetail.vue';
import Maintenances from  '@/pages/Maintenances.vue';
import MaintenanceDetail from  '@/pages/MaintenanceDetail.vue';
import Employees from  '@/pages/Employees.vue';
import EmployeeDetail from  '@/pages/EmployeeDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/flights',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/flights',
		name: 'Flights',
		layout: DefaultLayout,
		component: Flights,
	},
	{
	    path: '/flight/:flightId', 
	    name: 'FlightDetail',
		layout: DefaultLayout,
	    component: FlightDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airlines',
		name: 'Airlines',
		layout: DefaultLayout,
		component: Airlines,
	},
	{
	    path: '/airline/:airlineId', 
	    name: 'AirlineDetail',
		layout: DefaultLayout,
	    component: AirlineDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/aircrafts',
		name: 'Aircrafts',
		layout: DefaultLayout,
		component: Aircrafts,
	},
	{
	    path: '/aircraft/:aircraftId', 
	    name: 'AircraftDetail',
		layout: DefaultLayout,
	    component: AircraftDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/passengers',
		name: 'Passengers',
		layout: DefaultLayout,
		component: Passengers,
	},
	{
	    path: '/passenger/:passengerId', 
	    name: 'PassengerDetail',
		layout: DefaultLayout,
	    component: PassengerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bookings',
		name: 'Bookings',
		layout: DefaultLayout,
		component: Bookings,
	},
	{
	    path: '/booking/:bookingId', 
	    name: 'BookingDetail',
		layout: DefaultLayout,
	    component: BookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airports',
		name: 'Airports',
		layout: DefaultLayout,
		component: Airports,
	},
	{
	    path: '/airport/:airportId', 
	    name: 'AirportDetail',
		layout: DefaultLayout,
	    component: AirportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/tickets',
		name: 'Tickets',
		layout: DefaultLayout,
		component: Tickets,
	},
	{
	    path: '/ticket/:ticketId', 
	    name: 'TicketDetail',
		layout: DefaultLayout,
	    component: TicketDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/crews',
		name: 'Crews',
		layout: DefaultLayout,
		component: Crews,
	},
	{
	    path: '/crew/:crewId', 
	    name: 'CrewDetail',
		layout: DefaultLayout,
	    component: CrewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/crewAssignments',
		name: 'CrewAssignments',
		layout: DefaultLayout,
		component: CrewAssignments,
	},
	{
	    path: '/crewAssignment/:crewAssignmentId', 
	    name: 'CrewAssignmentDetail',
		layout: DefaultLayout,
	    component: CrewAssignmentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/routes',
		name: 'Routes',
		layout: DefaultLayout,
		component: Routes,
	},
	{
	    path: '/route/:routeId', 
	    name: 'RouteDetail',
		layout: DefaultLayout,
	    component: RouteDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/baggages',
		name: 'Baggages',
		layout: DefaultLayout,
		component: Baggages,
	},
	{
	    path: '/baggage/:baggageId', 
	    name: 'BaggageDetail',
		layout: DefaultLayout,
	    component: BaggageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/checkIns',
		name: 'CheckIns',
		layout: DefaultLayout,
		component: CheckIns,
	},
	{
	    path: '/checkIn/:checkInId', 
	    name: 'CheckInDetail',
		layout: DefaultLayout,
	    component: CheckInDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/gates',
		name: 'Gates',
		layout: DefaultLayout,
		component: Gates,
	},
	{
	    path: '/gate/:gateId', 
	    name: 'GateDetail',
		layout: DefaultLayout,
	    component: GateDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/meals',
		name: 'Meals',
		layout: DefaultLayout,
		component: Meals,
	},
	{
	    path: '/meal/:mealId', 
	    name: 'MealDetail',
		layout: DefaultLayout,
	    component: MealDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/loyaltyPrograms',
		name: 'LoyaltyPrograms',
		layout: DefaultLayout,
		component: LoyaltyPrograms,
	},
	{
	    path: '/loyaltyProgram/:loyaltyProgramId', 
	    name: 'LoyaltyProgramDetail',
		layout: DefaultLayout,
	    component: LoyaltyProgramDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/memberships',
		name: 'Memberships',
		layout: DefaultLayout,
		component: Memberships,
	},
	{
	    path: '/membership/:membershipId', 
	    name: 'MembershipDetail',
		layout: DefaultLayout,
	    component: MembershipDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/boardingPasss',
		name: 'BoardingPasss',
		layout: DefaultLayout,
		component: BoardingPasss,
	},
	{
	    path: '/boardingPass/:boardingPassId', 
	    name: 'BoardingPassDetail',
		layout: DefaultLayout,
	    component: BoardingPassDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/feedbacks',
		name: 'Feedbacks',
		layout: DefaultLayout,
		component: Feedbacks,
	},
	{
	    path: '/feedback/:feedbackId', 
	    name: 'FeedbackDetail',
		layout: DefaultLayout,
	    component: FeedbackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/maintenances',
		name: 'Maintenances',
		layout: DefaultLayout,
		component: Maintenances,
	},
	{
	    path: '/maintenance/:maintenanceId', 
	    name: 'MaintenanceDetail',
		layout: DefaultLayout,
	    component: MaintenanceDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/employees',
		name: 'Employees',
		layout: DefaultLayout,
		component: Employees,
	},
	{
	    path: '/employee/:employeeId', 
	    name: 'EmployeeDetail',
		layout: DefaultLayout,
	    component: EmployeeDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
