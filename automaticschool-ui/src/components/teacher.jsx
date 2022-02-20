import React, {Component} from "react";
import axios from 'axios';
import BootstrapTable from 'react-bootstrap-table-next';
import paginatorFactory from 'react-bootstrap-table2-paginator';
import * as ReactBootstrap from 'react-bootstrap';
import data from "bootstrap/js/src/dom/data";
import moment from 'moment';

class TeacherTable extends Component {
    state = {
        teachers:[],
        columns :[{
            dataField: 'id',
            text: 'ID'
        }, {
            dataField: 'name',
            text: 'Name'
        }, {
            dataField: 'surname',
            text: 'Surname'
        },{
            dataField: 'dob',
            text: 'Date of Birth',
            formatter: (date) => {
                return (moment(date,"YYYY-MM-DD").format("DD-MM-YYYY"));
            }
        },{
            dataField: 'phoneNumber',
            text: 'Phone Number',
            formatter: (number) => {
                return(number.replace(/^(.{3})(.{3})(.*)$/, "$1 $2 $3"));
            }
        },{
            dataField: 'email',
            text: 'Email'
        }],
        loading: false
    };

    componentDidMount() {
        axios.get(
          'http://localhost:8080/api/teachers'
        )
        .then(response => {
            this.setState({ teachers: response.data });
            console.log(response.data);
        })
        .catch(function(error) {
            console.log(error);
        });
        this.setState({loading: true});
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

export default TeacherTable;