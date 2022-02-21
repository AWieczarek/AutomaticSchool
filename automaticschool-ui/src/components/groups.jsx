import React, {Component} from "react";
import axios from 'axios';
import BootstrapTable from 'react-bootstrap-table-next';
import paginatorFactory from 'react-bootstrap-table2-paginator';
import * as ReactBootstrap from 'react-bootstrap';
import moment from 'moment';

class GroupTable extends Component {
    state = {
        teachers:[],
        columns :[{
            dataField: 'id',
            text: 'ID'
        },
        {
            dataField: 'teacher',
            text: 'Teacher',
            formatter: (teacher) =>{
                return( `${teacher.name} ${teacher.surname}`);
            }
        },{
            dataField: 'course.name',
            text: 'Course'
        },{
            dataField: 'startDate',
            text: 'Start Date',
            formatter: (date) => {
                return (moment(date,"YYYY-MM-DD").format("DD-MM-YYYY"));
            }
        },{
            dataField: 'expectedEndDate',
            text: 'Expected End Date',
            formatter: (date) => {
                return (moment(date,"YYYY-MM-DD").format("DD-MM-YYYY"));
            }
        },{
            dataField: 'ratePerHour',
            text: 'Rate Per Hour'
        }],
        loading: false
    };

    componentDidMount() {
        axios.get(
          'http://localhost:8080/api/groups'
        )
        .then(response => {
            this.setState({ teachers: response.data });
            console.log(response.data);
            this.setState({loading: true});
        })
        .catch(function(error) {
            console.log(error);
        });

    }

    render() {
        return(
            <div className ="m-lg-5" >
                {this.state.loading ?
                    (
                        <BootstrapTable
                            keyField="id"
                            data={this.state.teachers}
                            columns={this.state.columns}
                            pagination={paginatorFactory()}
                        />
                    ) : (
                        <ReactBootstrap.Spinner animation="border"/>
                    )}
            </div>
        )
    };
}

export default GroupTable;